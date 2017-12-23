package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.creature.monster.monsters.GiantSpider;
import com.duels.dungeon.models.creature.monster.monsters.Minotaur;
import com.duels.dungeon.models.creature.monster.monsters.Skeleton;
import com.duels.dungeon.utils.Printer;

import java.util.ArrayList;

public class Duel {

    private Player player;
    private ArrayList<Monster> monsters;
    private Monster monster;
    private Battle battle;
    private Setup setup;
    private int round;

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

    public Setup getSetup() {
        return setup;
    }

    public void play() {
        Printer.startLogo();
        this.setRound(0);
        setup.setUpPlayer();
        setup.setUpMonster(this.monsters, this.getRound());
        battle.processDuel(Boolean.FALSE);
    }

}
