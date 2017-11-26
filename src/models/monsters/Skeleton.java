package models.monsters;

import constants.Constants;
import models.base.DamageBonusCreature;

public class Skeleton extends DamageBonusCreature {

    public Skeleton() {
        super ("Skeleton", Constants.SKELETON_HEALTH, Constants.SKELETON_DAMAGE, Constants.SKELETON_DEFENCE);
    }

    public void attack() {
        this.addBonusDamage(this.getName(),
                this.getDamage(),
                Constants.SKELETON_DAMAGE_BONUS_POINT,
                Constants.SKELETON_DAMAGE_BONUS_CHANCE,
                Constants.DAMAGE_TYPE_PHYSICAL);
    }

    public void defense(int damage) {
        this.getDamage(this.getName(), damage);
    }

}