package com.duels.dungeon.cycle;

import com.duels.dungeon.models.base.Monster;
import com.duels.dungeon.models.base.Player;
import com.duels.dungeon.utils.Printer;

import java.util.ArrayList;

public class EndPhase {

    private Battle battle;
    private Duel duel;

    public EndPhase() {
        this.battle = new Battle();
        this.duel = new Duel();
    }

    public void monsterDefeatPlayer() {
        Printer.monsterDefeatPlayer();
    }

    public void playerDefeatMonster(Player player, Monster monster, int round, ArrayList<Monster> monsters) {
        Printer.playerDefeatMonster(player.getName(), monster.getName());
        duel.setRound(round += 1);
        if (round + 1 > monsters.size()) {
            Printer.victory(player.getName());
        } else {
            battle.faceNextEnemy(monsters, round, player);
        }
    }
}
