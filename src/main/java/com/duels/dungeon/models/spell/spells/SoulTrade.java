package com.duels.dungeon.models.spell.spells;

import com.duels.dungeon.models.spell.SpecialPower;
import com.duels.dungeon.utils.Constants;

/**
 * Represents an soul trade.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class SoulTrade extends SpecialPower {

    /**
     * Creates an soul trade.
     * Use parameters spell power name (type String),
     * damage type (type String),
     * damage (type int).
     */
    public SoulTrade() {
        super(Constants.SOUL_TRADE, Constants.DAMAGE_TYPE_MAGIC, Constants.SOUL_TRADE_DAMAGE);
    }
}


