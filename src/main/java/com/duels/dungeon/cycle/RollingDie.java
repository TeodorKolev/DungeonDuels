package com.duels.dungeon.cycle;

import java.util.Random;

public class RollingDie {

    private Random random;
    private int sidesCount;

    public RollingDie() {
        this.sidesCount = 100;
        this.random = new Random();
    }

    private int getSidesCount() {
        return sidesCount;
    }

    public int roll() {
        return random.nextInt(this.getSidesCount()) + 1;
    }

}
