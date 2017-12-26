package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.creature.monster.monsters.GiantSpider;
import com.duels.dungeon.models.creature.monster.monsters.Minotaur;
import com.duels.dungeon.models.creature.monster.monsters.Skeleton;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.utils.Printer;

import java.util.ArrayList;

/**
 * Represents an duel.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class Duel {

    private Player player;
    private ArrayList<Monster> monsters;
    private Monster monster;
    private Battle battle;
    private Setup setup;
    private int round;

    /**
     * Creates an duel.
     * Defines battle. Type Battle class.
     * Defines setup. Type Setup class.
     * Defines monsters and set it. ArrayList from Monster class.
     */
    public Duel() {
        this.battle = new Battle(this);
        this.setup = new Setup(this);
        monsters = new ArrayList<Monster>();
        Skeleton skeleton = new Skeleton();
        GiantSpider giantSpider = new GiantSpider();
        Minotaur minotaur = new Minotaur();
        monsters.add(skeleton);
        monsters.add(giantSpider);
        monsters.add(minotaur);
        this.setMonsters(monsters);
    }

    /**
     * Retrieve duel's player.
     * @return player object. Type Player class.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets duels's player.
     * @param player Type Player Class.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Sets duels's monster from monster array according to position number.
     * @param monsters array. Type ArrayList from Monster class.
     * @param position of array. Type int.
     */
    public void setMonster(ArrayList<Monster> monsters, int position) {
        this.monster = monsters.get(position);
    }

    /**
     * Retrieve duels's monster.
     * @return monster object. Type Monster Class.
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * Retrieve duel's current round.
     * @return duel. Type int.
     */
    public int getRound() {
        return round;
    }

    /**
     * Sets duels's current round.
     * @param round number. Type int.
     */
    public void setRound(int round) {
        this.round = round;
    }

    /**
     * Retrieve duel's monsters array.
     * @return monsters array. Type ArrayList from Monster class.
     */
    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    /**
     * Sets duel's monsters array.
     * @param monsters array. Type ArrayList from Monster class.
     */
    private void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    /**
     * Retrieve duel's setup.
     * @return setup object. Type Setup class.
     */
    public Setup getSetup() {
        return setup;
    }

    /**
     * Prints opening logo. Sets start round. Setup player and monster and starts duel.
     */
    public void play() {
        Printer.startLogo();
        this.setRound(Constants.DUEL_STARTING_ROUND_VALUE);
        setup.setUpPlayer();
        setup.setUpMonster(this.getMonsters(), this.getRound());
        battle.processDuel(Boolean.FALSE);
    }

}
