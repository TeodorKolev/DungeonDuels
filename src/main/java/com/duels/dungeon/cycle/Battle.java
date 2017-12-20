package com.duels.dungeon.cycle;

import com.duels.dungeon.models.base.Monster;
import com.duels.dungeon.models.base.Player;
import com.duels.dungeon.utils.Printer;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle {

    private Turn turn;
    private EndPhase endPhase;
    private Scanner scanner;
    private Duel duel;

    public Battle(Duel duel) {
        this.turn = new Turn();
        this.endPhase = new EndPhase(this);
        this.scanner = new Scanner(System.in);
        this.duel = duel;
    }

    public Duel getDuel() {
        return duel;
    }

    public void duelPhase(Player player, Monster monster, int round, ArrayList<Monster> monsters) {
        turn.playerTurn(player, monster);
        if (monster.isAlive()) {
            turn.monsterTurn(player, monster);
            if (player.isAlive()) {
                this.processDuel(Boolean.TRUE);
            } else {
                endPhase.monsterDefeatPlayer();
            }
        } else {
            endPhase.playerDefeatMonster(player, monster, round, monsters);
        }
    }

    public void faceNextEnemy(ArrayList<Monster> monsters, int round, Player player) {
        duel.getSetup().setUpMonster(monsters, round);
        player.replenishLife();
        this.processDuel(Boolean.FALSE);
    }

    public void processDuel(boolean duelPhase) {
        if (duelPhase == Boolean.TRUE) {
            Printer.processDuelPhase();
        } else {
            Printer.beginDuel();
        }
        scanner.nextLine();
        if (scanner.hasNextLine()) {
            this.duelPhase(duel.getPlayer(), duel.getMonster(), duel.getRound(), duel.getMonsters());
        }
    }
}
