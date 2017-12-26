package com.duels.dungeon.cycle;

import com.duels.dungeon.utils.Constants;

import java.util.Random;

/**
 * Represents an rolling die.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class RollingDie {

    private Random random;
    private int percents;

    /**
     * Creates an rolling die.
     * Defines percents. Default value of 100. Type int.
     * Defines random. Type Random class.
     */
    public RollingDie() {
        this.percents = Constants.ROLLING_DIE_PERCENTS_DEFAULT_VALUE;
        this.random = new Random();
    }

    /**
     * Retrieve percents.
     * @return percents. Type int.
     */
    private int getPercents() {
        return percents;
    }

    /**
     * Get value from random.
     * @return random value. Type int.
     */
    public int roll() {
        // Random starts from zero. Needs to add 1 to get 100 instead of 99.
        return random.nextInt(this.getPercents()) + 1;
    }

}
