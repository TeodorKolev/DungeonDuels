package com.duels.dungeon.models.creature.player.heroes;

import com.duels.dungeon.models.spell.SpecialPower;
import com.duels.dungeon.models.spell.spells.LightningBold;
import com.duels.dungeon.utils.Constants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MageTest {

    private Mage mage;
    private SpecialPower specialPower;

    @Before
    public void setUp() throws Exception {
        this.mage = new Mage("mage");
        this.specialPower = new LightningBold();
        assertNotNull(mage);
    }

    @Test
    public void getName() {
        assertEquals("mage", mage.getName());
    }

    @Test
    public void attack() {
        mage.attack();
        assertEquals(Constants.MAGE_DAMAGE, mage.getDamage());
        assertEquals(Constants.DAMAGE_TYPE_PHYSICAL, mage.getDamageDealtType());
    }

    @Test
    public void defense() {
    }

    @Test
    public void replenishLife() {
    }

    @Test
    public void getSpecialPower() {
    }

    @Test
    public void getSpecialPowerCastChance() {
    }

    @Test
    public void castSpecial() {
    }
}