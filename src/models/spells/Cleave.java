package models.spells;

import utils.Constants;
import models.base.SpecialPower;

public class Cleave extends SpecialPower {

    public Cleave(int damage) {
        super("Cleave", Constants.DAMAGE_TYPE_MAGIC, damage);
    }
}
