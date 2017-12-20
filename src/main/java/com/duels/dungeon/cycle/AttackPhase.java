package com.duels.dungeon.cycle;

import com.duels.dungeon.models.base.BonusDamagеable;
import com.duels.dungeon.models.base.Monster;
import com.duels.dungeon.models.base.Player;


public class AttackPhase {

    private RollingDie rollingDie;
    private int randomInt;

    public AttackPhase() {
         this.rollingDie = new RollingDie();
    }

    public void attack(Player player, Monster monster, boolean heroCast) {
        randomInt = rollingDie.roll();
        if (heroCast) {
            if (player instanceof BonusDamagеable) {
                ((BonusDamagеable) player).empowerAttack(randomInt);
                ((BonusDamagеable) player).resetDamage();
            } else {
                player.attack();
            }
        } else {
            if (monster instanceof BonusDamagеable) {
                ((BonusDamagеable) monster).empowerAttack(randomInt);
                ((BonusDamagеable) monster).resetDamage();
            } else {
                monster.attack();
            }
        }
    }

}
