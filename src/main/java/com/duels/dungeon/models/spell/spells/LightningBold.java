package com.duels.dungeon.models.spell.spells;

import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.models.spell.SpecialPower;

public class LightningBold extends SpecialPower {

    public LightningBold() {
        super(Constants.LIGHTNING_BOLD, Constants.DAMAGE_TYPE_MAGIC, Constants.LIGHTNING_BOLD_DAMAGE);
    }
}
