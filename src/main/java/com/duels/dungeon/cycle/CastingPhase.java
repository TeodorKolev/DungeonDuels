package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.creature.SpellCastable;
import com.duels.dungeon.models.creature.player.heroes.Warlock;

public class CastingPhase {

    private RollingDie rollingDie;
    private int randomInt;

    public CastingPhase() {
        this.rollingDie = new RollingDie();
        this.randomInt = 0;
    }

    public void castSpecial(Player player, Monster monster, boolean heroCast) {
        randomInt = rollingDie.roll();
        if (heroCast) {
            if (player instanceof Warlock) {
                ((Warlock) player).specialPenalty(randomInt);
                if (randomInt <= (((SpellCastable) player).getSpecialPowerCastChance())) {
                    monster.defense(player.getDamageDealt(), player.getDamageDealtType());
                }
            } else {
                if (randomInt <= (((SpellCastable) player).getSpecialPowerCastChance())) {
                    ((SpellCastable) player).castSpecial();
                    monster.defense(player.getDamageDealt(), player.getDamageDealtType());
                }
            }
        } else {
            if (randomInt <= (((SpellCastable) monster).getSpecialPowerCastChance())) {
                ((SpellCastable) monster).castSpecial();
                player.defense(monster.getDamageDealt(), monster.getDamageDealtType());
            }
        }
    }
}