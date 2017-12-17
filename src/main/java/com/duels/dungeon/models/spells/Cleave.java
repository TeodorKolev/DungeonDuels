package com.duels.dungeon.models.spells;

import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.models.base.SpecialPower;

public class Cleave extends SpecialPower {

    private int damage;

    public Cleave(int damage) {
        super(Constants.CLEAVE, Constants.DAMAGE_TYPE_MAGIC);
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        return damage;
    }

}
