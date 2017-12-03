package models.spells;

import utils.Constants;
import models.base.SpecialPower;

public class LightingBold extends SpecialPower {

    public LightingBold() {
        super("Lighting Bold", Constants.DAMAGE_TYPE_MAGIC, Constants.LIGHTING_BOLD_DAMAGE, Constants.TARGET_ENEMY);
    }
}
