package com.duels.dungeon.models.spell.spells;

import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.models.spell.SpecialPower;

/**
 * Represents an lightning bold.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class LightningBold extends SpecialPower {

    /**
     * Creates an lightning bold.
     * Use parameters spell power name (type String),
     * damage type (type String),
     * damage (type int).
     */
    public LightningBold() {
        super(Constants.LIGHTNING_BOLD, Constants.DAMAGE_TYPE_MAGIC, Constants.LIGHTNING_BOLD_DAMAGE);
    }
}
