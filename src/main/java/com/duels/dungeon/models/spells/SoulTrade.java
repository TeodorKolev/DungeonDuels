package com.duels.dungeon.models.spells;

import com.duels.dungeon.models.base.SpecialPower;
import com.duels.dungeon.utils.Constants;

public class SoulTrade extends SpecialPower {

    public SoulTrade() {
        super(Constants.SOUL_TRADE, Constants.DAMAGE_TYPE_MAGIC, Constants.SOUL_TRADE_DAMAGE);
    }
}


