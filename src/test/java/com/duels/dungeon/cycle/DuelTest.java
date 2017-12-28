package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.monster.monsters.GiantSpider;
import com.duels.dungeon.models.creature.monster.monsters.Minotaur;
import com.duels.dungeon.models.creature.monster.monsters.Skeleton;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.creature.player.heroes.Warlock;
import com.duels.dungeon.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DuelTest {

    private Player player;
    private String playerName;
    private ArrayList<Monster> monsters;
    private Monster monster;
    private Battle battle;
    private Setup setup;
    private int round;
    private Duel duel;

    @Before
    public void setUp() throws Exception {
        this.playerName = "playerName";
        this.duel = new Duel();
        this.battle = Mockito.spy(new Battle(duel));
        this.setup = Mockito.spy(new Setup(duel));
        this.player = new Warlock(playerName);
        this.monster = new Skeleton();
        this.round = 0;
        monsters = new ArrayList<Monster>();
        Skeleton skeleton = new Skeleton();
        GiantSpider giantSpider = new GiantSpider();
        Minotaur minotaur = new Minotaur();
        monsters.add(skeleton);
        monsters.add(giantSpider);
        monsters.add(minotaur);
    }

    @Test
    public void getPlayer() {
        duel.getPlayer();
        assertNotNull(player);
    }

    @Test
    public void setPlayer() {
        duel.setPlayer(player);
        assertNotNull(player);
    }

    @Test
    public void setMonster() {
        duel.setMonster(monsters, 0);
        assertNotNull(monster);
    }

    @Test
    public void getMonster() {
        duel.getMonster();
        assertNotNull(monster);
    }

    @Test
    public void getRound() {
        duel.getRound();
        assertNotNull(round);
    }

    @Test
    public void setRound() {
        duel.setRound(0);
        assertNotNull(round);
    }

    @Test
    public void getMonsters() {
        duel.getMonsters();
        assertNotNull(monsters);
    }

    @Test
    public void getSetup() {
        duel.getSetup();
        assertNotNull(setup);
    }

    @Test
    public void play() {
/*        TODO play scanner
        Mockito.doNothing().when(setup).setUpPlayer();
        Mockito.doNothing().when(setup).setUpMonster(monsters, 0);
        Mockito.doNothing().when(battle).processDuel(Boolean.FALSE);
        duel.play();
        duel.setRound(0);
        setup.setUpPlayer();
        setup.setUpMonster(monsters, 0);
        battle.processDuel(Boolean.FALSE);
        Mockito.verify(setup).setUpPlayer();
        Mockito.verify(setup).setUpMonster(monsters, 0);
        Mockito.verify(battle).processDuel(Boolean.FALSE);*/
    }
}