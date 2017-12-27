package com.duels.dungeon.models.spell.spells;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpiderVenomTest {

    private SpiderVenom spiderVenom;
    private int spiderVenomDamage;

    @Before
    public void setUp() throws Exception {
        this.spiderVenomDamage = 15;
        this.spiderVenom = new SpiderVenom(spiderVenomDamage);
        assertNotNull(spiderVenom);
    }

    @Test
    public void getDamage() {
        assertEquals(spiderVenomDamage, spiderVenom.getDamage());
    }
}