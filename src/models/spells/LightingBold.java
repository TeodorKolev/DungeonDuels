package models.spells;

import constants.Constants;
import models.base.SpecialPower;

public class LightingBold extends SpecialPower {

    public LightingBold() {
        super("Lighting Bold", Constants.DAMAGE_TYPE_MAGIC, Constants.LIGHTING_BOLD_DAMAGE);
    }
}
