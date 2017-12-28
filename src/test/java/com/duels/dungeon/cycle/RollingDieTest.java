package com.duels.dungeon.cycle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RollingDieTest {

    private RollingDie rollingDie;

    @Before
    public void setUp() throws Exception {
        this.rollingDie = new RollingDie();
    }

    @Test
    public void roll() {
        for(int x = 1; x < 1000; x = x + 1) {
            int number = rollingDie.roll();
            assertTrue(number >= 0 && number <= 100);
        }
    }
}