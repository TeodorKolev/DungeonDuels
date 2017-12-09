package models.monsters;

import interfaces.iCastable;
import models.base.DamageBonusCreature;
import models.base.SpecialPower;
import models.spells.SpiderVenom;
import utils.Constants;
import utils.Printer;

public class GiantSpider extends DamageBonusCreature implements iCastable {

    public GiantSpider() {
        super (Constants.GIANT_SPIDER, Constants.GIANT_SPIDER_HEALTH, Constants.GIANT_SPIDER_DAMAGE,
                Constants.GIANT_SPIDER_DEFENSE);
    }

    public void attack() {
        this.addBonusDamage(this.getName(),
                this.takeDamage(),
                Constants.GIANT_SPIDER_DAMAGE_BONUS_POINT,
                Constants.GIANT_SPIDER_DAMAGE_BONUS_CHANCE,
                Constants.DAMAGE_TYPE_PHYSICAL);
    }

    public void defense(int damage, String damageType) {
        this.takeDamage(this.getName(), damage, damageType);
    }

    @Override
    public SpecialPower getSpecialPower() {
        return new SpiderVenom(Constants.SPIDER_VENOM_DAMAGE + this.getHealth() / 10);
    }

    @Override
    public int getSpecialPowerCastChance() {
        return Constants.GIANT_SPIDER_DAMAGE_BONUS_CHANCE;
    }

    @Override
    public void castSpecial() {
        this.setDamageDealt(this.getSpecialPower().getDamage());
        this.setDamageDealtType(this.getSpecialPower().getType());
        Printer.warriorCastSpecial(this.getName(), this.getSpecialPower().getName(), this.getSpecialPower().getDamage());
    }
}