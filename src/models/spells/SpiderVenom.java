package models.spells;

import models.base.SpecialPower;
import utils.Constants;

public class SpiderVenom extends SpecialPower {

    public SpiderVenom(int damage) {
        super("Spider Venom", Constants.DAMAGE_TYPE_MAGIC, damage, Constants.TARGET_ENEMY);
    }
}
