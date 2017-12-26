package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.utils.Printer;

import java.util.ArrayList;

/**
 * Represents an duel end phase.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class EndPhase {

    private Battle battle;

    /**
     * Creates an end phase.
     * Defines battle. Type Battle class.
     */
    public EndPhase(Battle battle) {
        this.battle = battle;
    }

    /**
     * Prints monster victory.
     */
    public void monsterDefeatPlayer() {
        Printer.monsterDefeatPlayer();
    }

    /**
     * Prints player victory. Calculates does monster is last from monsters array
     * and print end if it is.
     * @param player player object. Type Player class.
     * @param round current round. Type int.
     * @param  monsters array of monsters. Type ArrayList from Monster object.
     */
    public void playerDefeatMonster(Player player, Monster monster, int round, ArrayList<Monster> monsters) {
        Printer.playerDefeatMonster(player.getName(), monster.getName());
        battle.getDuel().setRound(round += 1);
        if (round + 1 > monsters.size()) {
            Printer.victory(player.getName());
        } else {
            battle.faceNextEnemy(monsters, round, player);
        }
    }
}
