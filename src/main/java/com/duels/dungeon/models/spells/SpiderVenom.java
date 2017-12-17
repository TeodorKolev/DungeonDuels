package com.duels.dungeon.models.spells;

import com.duels.dungeon.models.base.SpecialPower;
import com.duels.dungeon.utils.Constants;

public class SpiderVenom extends SpecialPower {

    private int damage;

    public SpiderVenom(int damage) {
        super(Constants.SPIDER_VENOM, Constants.DAMAGE_TYPE_MAGIC);
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        return damage;
    }

}
