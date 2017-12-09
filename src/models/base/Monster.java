package models.base;

import models.monsters.GiantSpider;
import models.monsters.Skeleton;
import utils.Constants;

public class Monster extends Entity {

    private Creature creature;
    private SpecialPower specialPower;
    private int specialPowerCastChance;

    public Monster(Creature creature) {
        super(Constants.MONSTER);
        this.creature = creature;
    }

    public Creature getCreature() {
        return creature;
    }

    public void attack() {
        if (creature instanceof Skeleton) {
            ((Skeleton) creature).attack();
        } else if (creature instanceof GiantSpider) {
            ((GiantSpider) creature).attack();
        }
    }

    public void defense(int damage, String damageType) {
        if (creature instanceof Skeleton) {
            ((Skeleton) creature).defense(damage, damageType);
        } else if (creature instanceof GiantSpider) {
            ((GiantSpider) creature).defense(damage, damageType);
        }
    }

    public int getSpecialPowerCastChance() {
        if (creature instanceof GiantSpider) {
            specialPowerCastChance = ((GiantSpider) creature).getSpecialPowerCastChance();
        }
        return specialPowerCastChance;
    }

    public SpecialPower getSpecialPower() {
        if (creature instanceof GiantSpider) {
            specialPower =  ((GiantSpider) creature).getSpecialPower();
        }
        return specialPower;
    }

    public void castSpecial() {
        if (creature instanceof GiantSpider) {
            ((GiantSpider) creature).castSpecial();
        }
    }

}
