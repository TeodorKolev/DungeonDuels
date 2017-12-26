package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.creature.SpellCastable;
import com.duels.dungeon.models.creature.player.heroes.Warlock;
import com.duels.dungeon.utils.Constants;

/**
 * Represents an duel casting phase.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class CastingPhase {

    private RollingDie rollingDie;
    private int randomInt;

    /**
     * Creates an casting phase.
     * Defines rolling die. Type Rolling die class.
     * Defines random number. Type int.
     */
    public CastingPhase() {
        this.rollingDie = new RollingDie();
        this.randomInt = Constants.RANDOM_INT_DEFAULT_VALUE;
    }

    /**
     * Casting phase. Fires player cast action or monster cast action according to
     * boolean parameter heroCast. Defines random number randomInt via RollingDie roll method.
     * If it is player turn - fire cast player action and monster defence action and vice versa.
     * If player has class of Warlock - always cast special. If not -
     * fires player cast action only on success according predefined random number.
     * @param player player object. Type Player class.
     * @param monster monster object. Type Monster class.
     * @param heroCast distinguish player from monster turn. Type boolean.
     */
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
