package models.spells;

import models.base.SpecialPower;
import utils.Constants;

public class SpiderVenom extends SpecialPower {

    private int damage;

    public SpiderVenom(int damage) {
        super(Constants.SPIDER_VENOM, Constants.DAMAGE_TYPE_MAGIC, Constants.TARGET_ENEMY);
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
