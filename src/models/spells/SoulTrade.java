package models.spells;

import models.base.SpecialPower;
import utils.Constants;

public class SoulTrade extends SpecialPower {

    public SoulTrade() {
        super(Constants.SOUL_TRADE, Constants.DAMAGE_TYPE_MAGIC, Constants.SOUL_TRADE_DAMAGE, Constants.TARGET_ENEMY);
    }
}


