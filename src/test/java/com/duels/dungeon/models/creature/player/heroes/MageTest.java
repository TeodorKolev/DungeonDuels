package com.duels.dungeon.models.creature.player.heroes;

import com.duels.dungeon.models.creature.Creature;
import com.duels.dungeon.models.spell.spells.LightningBold;
import com.duels.dungeon.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class MageTest {

    private Mage mage;
    private Creature creature;

    @Before
    public void setUp() throws Exception {
        this.mage = new Mage("mage");
        this.creature = Mockito.spy(new Creature(
                Constants.MAGE, Constants.MAGE_HEALTH, Constants.MAGE_DAMAGE, Constants.MAGE_DEFENSE));
        assertNotNull(mage);
        assertNotNull(creature);
    }

    @Test
    public void getName() {
        assertEquals("mage", mage.getName());
    }

    @Test
    public void attack() {
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        mage.attack();
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void defense() {
        Mockito.doNothing().when(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        mage.defense(15, Constants.DAMAGE_TYPE_PHYSICAL);
        creature.takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void replenishLife() {
        mage.replenishLife();
        assertEquals(Constants.MAGE_HEALTH, mage.getHealth());
    }

    @Test
    public void getSpecialPower() {
        assertEquals(LightningBold.class, mage.getSpecialPower().getClass());
    }

    @Test
    public void getSpecialPowerCastChance() {
        assertEquals(Constants.MAGE_CAST_SPECIAL_CHANCE, mage.getSpecialPowerCastChance());
    }

    @Test
    public void castSpecial() {
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        mage.castSpecial();
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }
}