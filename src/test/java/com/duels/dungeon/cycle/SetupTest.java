package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.monster.monsters.GiantSpider;
import com.duels.dungeon.models.creature.monster.monsters.Minotaur;
import com.duels.dungeon.models.creature.monster.monsters.Skeleton;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.creature.player.heroes.Warlock;
import com.duels.dungeon.models.creature.player.heroes.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SetupTest {

    private Duel duel;
    private ClassSelector classSelector;
    private NameSelector nameSelector;
    private Setup setup;
    private ArrayList<Monster> monsters;
    private Player player;
    private String playerName;
    private Monster monster;

    @Before
    public void setUp() throws Exception {
        this.playerName = "playerName";
        this.duel = Mockito.spy(new Duel());
        this.classSelector = Mockito.spy(new ClassSelector());
        this.nameSelector = Mockito.spy(new NameSelector());
        this.setup = new Setup(duel);
        this.player = Mockito.spy(new Warlock(playerName));
        this.monster = Mockito.spy(new Skeleton());
        monsters = new ArrayList<Monster>();
        Skeleton skeleton = new Skeleton();
        GiantSpider giantSpider = new GiantSpider();
        Minotaur minotaur = new Minotaur();
        monsters.add(skeleton);
        monsters.add(giantSpider);
        monsters.add(minotaur);
    }

    @Test
    public void setUpPlayer() {
        // TODO ClassSelector scanner
/*        Mockito.doReturn(3).when(classSelector).selectPlayerClass();
        Mockito.doReturn(playerName).when(nameSelector).setPlayerName();
        Mockito.doReturn(player).when(classSelector).setPlayerClass(Mockito.anyInt(), Mockito.anyString());
        Mockito.doNothing().when(duel).setPlayer(player);
        setup.setUpPlayer();
        duel.setPlayer(player);
        Mockito.verify(duel).setPlayer(player);
        assertNotNull(duel.getPlayer());*/
    }

    @Test
    public void setUpMonster() {
        Mockito.doNothing().when(duel).setMonster(monsters, 1);
        Mockito.doReturn(player).when(duel).getPlayer();
        Mockito.doReturn(playerName).when(player).getName();
        Mockito.doReturn(monster).when(duel).getMonster();
        Mockito.doReturn(playerName).when(monster).getName();
        setup.setUpMonster(monsters, 1);
        duel.getPlayer();
        duel.getPlayer().getName();
        duel.getMonster();
        duel.getMonster().getName();
        Mockito.verify(duel).setMonster(monsters, 1);
        assertEquals(monster, duel.getMonster());
    }
}