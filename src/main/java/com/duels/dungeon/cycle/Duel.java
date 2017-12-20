package com.duels.dungeon.cycle;

import com.duels.dungeon.models.base.Monster;
import com.duels.dungeon.models.base.Player;
import com.duels.dungeon.models.monsters.GiantSpider;
import com.duels.dungeon.models.monsters.Minotaur;
import com.duels.dungeon.models.monsters.Skeleton;
import com.duels.dungeon.utils.Printer;

import java.util.ArrayList;

public class Duel {

    private Player player;
    private ArrayList<Monster> monsters;
    private Monster monster;
    private int round;
    private Battle battle;
    private Skeleton skeleton = new Skeleton();
    private GiantSpider giantSpider = new GiantSpider();
    private Minotaur minotaur = new Minotaur();
    private Setup setup;

    public Duel() {
        this.battle = new Battle();
        monsters = new ArrayList<Monster>();
        skeleton = new Skeleton();
        giantSpider = new GiantSpider();
        minotaur = new Minotaur();
        monsters.add(skeleton);
        monsters.add(giantSpider);
        monsters.add(minotaur);
        this.setMonsters(monsters);
        this.setup = new Setup();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setMonster(ArrayList<Monster> monsters, int position) {
        this.monster = monsters.get(position);
    }

    public Monster getMonster() {
        return monster;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    private void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public void play() {
        Printer.startLogo();
        this.setRound(0);
        setup.setUpPlayer();
        setup.setUpMonster(this.monsters, this.getRound());
        battle.processDuel(Boolean.FALSE);
    }

}
