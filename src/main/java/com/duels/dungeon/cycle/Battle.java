package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.utils.Printer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents an duel battle phase.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class Battle {

    private Turn turn;
    private EndPhase endPhase;
    private Scanner scanner;
    private Duel duel;

    /**
     * Creates an attack phase.
     * @param duel Duel class.
     * Defines turn. Type Turn class.
     * Defines end phase. Type EndPhase class.
     * Defines scanner. Type Scanner class.
     */
    public Battle(Duel duel) {
        this.turn = new Turn();
        this.endPhase = new EndPhase(this);
        this.scanner = new Scanner(System.in);
        this.duel = duel;
    }

    /**
     * Retrieve duel.
     * @return duel. Type Duel class.
     */
    public Duel getDuel() {
        return duel;
    }

    /**
     * Process duel phase. Print either continue phase either begin phase
     * according to boolean parameter. Scan for input and fire duel phase.
     * @param duelPhase distinguish print result. Type boolean.
     */
    public void processDuel(boolean duelPhase) {
        if (duelPhase == Boolean.TRUE) {
            Printer.processDuelPhase();
            scanner.nextLine();
        } else {
            Printer.beginDuel();
        }
        if (scanner.hasNextLine()) {
            this.duelPhase(duel.getPlayer(), duel.getMonster(), duel.getRound(), duel.getMonsters());
        }
    }

    /**
     * Duel main method. Setup player attack turn turn, checks if monster is alive and set
     * monster turn. Check is player alive and repeat process via processDuel method.
     * Fire further methods for player or monster death.
     * @param player player object. Type Player class.
     * @param monster monster object. Type Monster class.
     * @param round current round. Type int.
     * @param monsters array list of all monsters opponents. Type ArrayList of Monster class.
     */
    private void duelPhase(Player player, Monster monster, int round, ArrayList<Monster> monsters) {
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

    /**
     * Handles player defeating monster phase. Setup next opponent in row. Replenish player life.
     * Fires process duel.
     * @param round current round. Type int.
     * @param monsters array list of all monsters opponents. Type ArrayList of Monster class.
     * @param player player object. Type Player class.
     */
    public void faceNextEnemy(ArrayList<Monster> monsters, int round, Player player) {
        duel.getSetup().setUpMonster(monsters, round);
        player.replenishLife();
        this.processDuel(Boolean.TRUE);
    }
}
