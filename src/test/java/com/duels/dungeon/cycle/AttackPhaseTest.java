package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.Creature;
import com.duels.dungeon.models.creature.monster.monsters.GiantSpider;
import com.duels.dungeon.models.creature.monster.monsters.Skeleton;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.creature.player.heroes.Mage;
import com.duels.dungeon.models.creature.player.heroes.Warrior;
import com.duels.dungeon.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AttackPhaseTest {

    private AttackPhase attackPhase;
    private RollingDie rollingDie;
    private Warrior warrior;
    private Mage mage;
    private Skeleton skeleton;
    private GiantSpider giantSpider;
    private String playerName;
    private Creature creature;
    private int randomInt;

    @Before
    public void setUp() throws Exception {
        this.randomInt = 55;
        this.playerName = "playerTest";
        this.attackPhase = new AttackPhase();
        this.rollingDie = Mockito.spy(new RollingDie());
        this.warrior = Mockito.spy(new Warrior(playerName));
        this.mage = Mockito.spy(new Mage(playerName));
        this.skeleton = Mockito.spy(new Skeleton());
        this.giantSpider = Mockito.spy(new GiantSpider());
        this.creature = Mockito.spy(new Creature(
                Constants.WARRIOR, Constants.WARRIOR_HEALTH, Constants.WARRIOR_DAMAGE, Constants.WARRIOR_DEFENSE));
        assertNotNull(attackPhase);
        assertNotNull(rollingDie);
    }

    @Test
    public void attackEmpoweredPlayer() {
        Mockito.doReturn(randomInt).when(rollingDie).roll();
        Mockito.doNothing().when(warrior).empowerAttack(Mockito.anyInt());
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.doNothing().when(warrior).resetDamage();
        attackPhase.attack(warrior, skeleton, Boolean.TRUE);
        rollingDie.roll();
        creature.setDamage(Mockito.anyInt());
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(rollingDie).roll();
        Mockito.verify(warrior).empowerAttack(Mockito.anyInt());
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(warrior).resetDamage();
        assertEquals(Constants.WARRIOR_DAMAGE, warrior.getDamage());
    }

    @Test
    public void attackNonEmpoweredPlayer() {
        Mockito.doReturn(randomInt).when(rollingDie).roll();
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        attackPhase.attack(mage, skeleton, Boolean.TRUE);
        rollingDie.roll();
        creature.setDamage(Mockito.anyInt());
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(rollingDie).roll();
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        assertEquals(Constants.MAGE_DAMAGE, mage.getDamage());
    }

    @Test
    public void attackEmpoweredMonster() {
        Mockito.doReturn(randomInt).when(rollingDie).roll();
        Mockito.doNothing().when(skeleton).empowerAttack(Mockito.anyInt());
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.doNothing().when(skeleton).resetDamage();
        attackPhase.attack(warrior, skeleton, Boolean.FALSE);
        rollingDie.roll();
        creature.setDamage(Mockito.anyInt());
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(rollingDie).roll();
        Mockito.verify(skeleton).empowerAttack(Mockito.anyInt());
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(skeleton).resetDamage();
        assertEquals(Constants.SKELETON_DAMAGE, skeleton.getDamage());
    }

    @Test
    public void attackNonEmpoweredMonster() {
        Mockito.doReturn(randomInt).when(rollingDie).roll();
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        attackPhase.attack(mage, giantSpider, Boolean.FALSE);
        rollingDie.roll();
        creature.setDamage(Mockito.anyInt());
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(rollingDie).roll();
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        assertEquals(Constants.GIANT_SPIDER_DAMAGE, giantSpider.getDamage());
    }
}