package com.duels.dungeon.cycle;

import java.util.Random;

public class RollingDie {

    private Random random;
    private int sidesCount;

    public RollingDie() {
        sidesCount = 100;
        random = new Random();
    }

    public int getSidesCount() {
        return sidesCount;
    }

    public int roll() {
        return random.nextInt(sidesCount) + 1;
    }

}
