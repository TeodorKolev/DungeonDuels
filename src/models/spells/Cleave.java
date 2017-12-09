package models.spells;

import utils.Constants;
import models.base.SpecialPower;

public class Cleave extends SpecialPower {

    private int damage;

    public Cleave(int damage) {
        super(Constants.CLEAVE, Constants.DAMAGE_TYPE_MAGIC, Constants.TARGET_ENEMY);
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
