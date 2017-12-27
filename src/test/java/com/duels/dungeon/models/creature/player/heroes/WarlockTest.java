package com.duels.dungeon.models.creature.player.heroes;

import com.duels.dungeon.models.creature.Creature;
import com.duels.dungeon.models.spell.spells.SoulTrade;
import com.duels.dungeon.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class WarlockTest {

    private Warlock warlock;
    private Creature creature;

    @Before
    public void setUp() throws Exception {
        this.warlock = new Warlock("warlock");
        this.creature = Mockito.spy(new Creature(
                Constants.WARLOCK, Constants.WARLOCK_HEALTH, Constants.WARLOCK_DAMAGE, Constants.WARLOCK_DEFENSE));
        assertNotNull(warlock);
        assertNotNull(creature);
    }

    @Test
    public void getName() {
        assertEquals("warlock", warlock.getName());
    }

    @Test
    public void attack() {
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        warlock.attack();
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void defense() {
        Mockito.doNothing().when(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        warlock.defense(15, Constants.DAMAGE_TYPE_PHYSICAL);
        creature.takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void replenishLife() {
        warlock.replenishLife();
        assertEquals(Constants.WARLOCK_HEALTH, warlock.getHealth());
    }

    @Test
    public void getSpecialPower() {
        assertEquals(SoulTrade.class, warlock.getSpecialPower().getClass());
    }

    @Test
    public void getSpecialPowerCastChance() {
        assertEquals(Constants.WARLOCK_CAST_SPECIAL_CHANCE, warlock.getSpecialPowerCastChance());
    }

    @Test
    public void castSpecial() {
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        warlock.castSpecial();
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void specialPenaltyCastSuccess() {
        Mockito.doNothing().when(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        warlock.specialPenalty(10);
        creature.takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void specialPenaltyCastFailed() {
        Mockito.doNothing().when(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        warlock.specialPenalty(67);
        creature.takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature, Mockito.never()).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

}