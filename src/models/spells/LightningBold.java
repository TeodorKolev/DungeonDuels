package models.spells;

import utils.Constants;
import models.base.SpecialPower;

public class LightningBold extends SpecialPower {

    public LightningBold() {
        super(Constants.LIGHTNING_BOLD, Constants.DAMAGE_TYPE_MAGIC, Constants.LIGHTNING_BOLD_DAMAGE, Constants.TARGET_ENEMY);
    }
}
