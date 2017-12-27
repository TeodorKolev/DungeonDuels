package com.duels.dungeon.models.spell.spells;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrenzyTest {

    private Frenzy frenzy;

    @Before
    @Test
    public void setUp() throws Exception {
        this.frenzy = new Frenzy();
        assertNotNull(frenzy);
    }
}