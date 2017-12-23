package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.creature.SpellCastable;

public class Turn {

    private AttackPhase attackPhase;
    private CastingPhase castingPhase;

    public Turn() {
        this.attackPhase = new AttackPhase();
        this.castingPhase = new CastingPhase();
    }

    public void playerTurn(Player player, Monster monster) {
        attackPhase.attack(player, monster, Boolean.TRUE);
        monster.defense(player.getDamageDealt(), player.getDamageDealtType());
        if (player instanceof SpellCastable) {
            castingPhase.castSpecial(player, monster, Boolean.TRUE);
        }
    }

    public void monsterTurn(Player player, Monster monster) {
        attackPhase.attack(player, monster, Boolean.FALSE);
        player.defense(monster.getDamageDealt(), monster.getDamageDealtType());
        if (monster instanceof SpellCastable) {
            castingPhase.castSpecial(player, monster, Boolean.FALSE);
        }
    }
}
