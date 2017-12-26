package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.BonusDamagеable;
import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.player.Player;


/**
 * Represents an duel attack phase.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class AttackPhase {

    private RollingDie rollingDie;
    private int randomInt;

    /**
     * Creates an attack phase.
     * Defines rolling die. Type RollingDie class.
     */
    public AttackPhase() {
         this.rollingDie = new RollingDie();
    }

    /**
     * Attack action. Set player or monster creature to attack distinguished by
     * heroCast boolean. Adds empowering attack according to random int.
     * @param player player object parameter. Type Player class.
     * @param monster monster object parameter. Type Monster class.
     * @param heroCast player parameter. Type boolean.
     */
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
