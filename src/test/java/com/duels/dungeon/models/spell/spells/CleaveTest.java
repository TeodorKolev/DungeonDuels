package com.duels.dungeon.models.spell.spells;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CleaveTest {

    private Cleave cleave;
    private int cleaveDamage;

    @Before
    public void setUp() throws Exception {
        this.cleaveDamage = 15;
        this.cleave = new Cleave(cleaveDamage);
        assertNotNull(cleave);
    }

    @Test
    public void getDamage() {
        assertEquals(cleaveDamage, cleave.getDamage());
    }
}