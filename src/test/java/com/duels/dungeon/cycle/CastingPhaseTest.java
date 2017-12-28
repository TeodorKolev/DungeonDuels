package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.Creature;
import com.duels.dungeon.models.creature.monster.monsters.GiantSpider;
import com.duels.dungeon.models.creature.monster.monsters.Skeleton;
import com.duels.dungeon.models.creature.player.heroes.Mage;
import com.duels.dungeon.models.creature.player.heroes.Warlock;
import com.duels.dungeon.models.creature.player.heroes.Warrior;
import com.duels.dungeon.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CastingPhaseTest {

    private RollingDie rollingDie;
    private CastingPhase castingPhase;
    private Warlock warlock;
    private Mage mage;
    private Skeleton skeleton;
    private GiantSpider giantSpider;
    private String playerName;
    private Creature creature;


    @Before
    public void setUp() throws Exception {
        this.playerName = "playerTest";
        this.rollingDie = Mockito.spy(new RollingDie());
        this.mage = Mockito.spy(new Mage(playerName));
        this.warlock = Mockito.spy(new Warlock(playerName));
        this.skeleton = Mockito.spy(new Skeleton());
        this.giantSpider = Mockito.spy(new GiantSpider());
        this.creature = Mockito.spy(new Creature(
                Constants.WARRIOR, Constants.WARRIOR_HEALTH, Constants.WARRIOR_DAMAGE, Constants.WARRIOR_DEFENSE));
        this.castingPhase =  Mockito.spy(new CastingPhase());
        assertNotNull(castingPhase);
    }

    @Test
    public void castSpecialPlayerNonWarlockSuccessCast() {
        Mockito.doReturn(10).when(rollingDie).roll();
        Mockito.doNothing().when(castingPhase).setRandomInt(10);
        Mockito.doReturn(10).when(castingPhase).getRandomInt();
        Mockito.doReturn(Constants.MAGE_CAST_SPECIAL_CHANCE).when(mage).getSpecialPowerCastChance();
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.doNothing().when(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        castingPhase.castSpecial(mage, skeleton, Boolean.TRUE);
        rollingDie.roll();
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        creature.takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(rollingDie).roll();
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void castSpecialPlayerNonWarlockFailCast() {
        Mockito.doReturn(55).when(rollingDie).roll();
        Mockito.doNothing().when(castingPhase).setRandomInt(55);
        Mockito.doReturn(55).when(castingPhase).getRandomInt();
        castingPhase.castSpecial(mage, skeleton, Boolean.TRUE);
        rollingDie.roll();
        Mockito.verify(rollingDie).roll();
        Mockito.verify(creature, Mockito.never()).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature, Mockito.never()).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void castSpecialPlayerWarlockSuccessCast() {
        Mockito.doNothing().when(warlock).specialPenalty(10);
        castingPhase.castSpecial(warlock, skeleton, Boolean.TRUE);
        warlock.specialPenalty(10);
        Mockito.verify(warlock).specialPenalty(10);
    }

    @Test
    public void castSpecialMonsterSuccessCast() {
        Mockito.doReturn(10).when(rollingDie).roll();
        Mockito.doNothing().when(castingPhase).setRandomInt(10);
        Mockito.doReturn(10).when(castingPhase).getRandomInt();
        Mockito.doReturn(Constants.GIANT_SPIDER_CAST_SPECIAL_CHANCE).when(giantSpider).getSpecialPowerCastChance();
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.doNothing().when(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        castingPhase.castSpecial(mage, giantSpider, Boolean.FALSE);
        rollingDie.roll();
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        creature.takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(rollingDie).roll();
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void castSpecialMonsterFailCast() {
        Mockito.doReturn(55).when(rollingDie).roll();
        Mockito.doNothing().when(castingPhase).setRandomInt(55);
        Mockito.doReturn(55).when(castingPhase).getRandomInt();
        Mockito.doReturn(Constants.GIANT_SPIDER_CAST_SPECIAL_CHANCE).when(giantSpider).getSpecialPowerCastChance();
        castingPhase.castSpecial(mage, giantSpider, Boolean.FALSE);
        rollingDie.roll();
        Mockito.verify(rollingDie).roll();
        Mockito.verify(creature, Mockito.never()).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature, Mockito.never()).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }
}