package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.creature.SpellCastable;

/**
 * Represents an duel turn.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class Turn {

    private AttackPhase attackPhase;
    private CastingPhase castingPhase;

    /**
     * Creates turn.
     * Defines attack phase. Type AttackPhase class.
     * Defines casting phase. Type CastingPhase class.
     */
    public Turn() {
        this.attackPhase = new AttackPhase();
        this.castingPhase = new CastingPhase();
    }

    /**
     * Player turn action. Set player to attack and monster to defense.
     * Check of player is caster and if it is fires cast spell action.
     * @param player object. Type Player class.
     * @param monster object. Type monster class.
     */
    public void playerTurn(Player player, Monster monster) {
        attackPhase.attack(player, monster, Boolean.TRUE);
        monster.defense(player.getDamageDealt(), player.getDamageDealtType());
        if (player instanceof SpellCastable) {
            castingPhase.castSpecial(player, monster, Boolean.TRUE);
        }
    }

    /**
     * Monster turn action. Set monster to attack and player to defense.
     * Check of monster is caster and if it is fires cast spell action.
     * @param player object. Type Player class.
     * @param monster object. Type monster class.
     */
    public void monsterTurn(Player player, Monster monster) {
        attackPhase.attack(player, monster, Boolean.FALSE);
        player.defense(monster.getDamageDealt(), monster.getDamageDealtType());
        if (monster instanceof SpellCastable) {
            castingPhase.castSpecial(player, monster, Boolean.FALSE);
        }
    }
}
