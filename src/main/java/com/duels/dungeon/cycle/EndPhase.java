package com.duels.dungeon.cycle;

import com.duels.dungeon.models.base.Monster;
import com.duels.dungeon.models.base.Player;
import com.duels.dungeon.utils.Printer;

import java.util.ArrayList;

public class EndPhase {

    private Battle battle;

    public EndPhase(Battle battle) {
        this.battle = battle;
    }

    public void monsterDefeatPlayer() {
        Printer.monsterDefeatPlayer();
    }

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
