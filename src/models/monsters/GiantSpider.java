package models.monsters;

import interfaces.ISpellCaster;
import models.base.DamageBonusCreature;
import models.base.Monster;
import models.base.SpecialPower;
import models.spells.SpiderVenom;
import utils.Constants;
import utils.Printer;

public class GiantSpider extends Monster implements ISpellCaster {

    private SpecialPower specialPower;
    private int specialPowerCastChance;

    public GiantSpider() {
        super (Constants.GIANT_SPIDER, Constants.GIANT_SPIDER_HEALTH, Constants.GIANT_SPIDER_DAMAGE,
                Constants.GIANT_SPIDER_DEFENSE);
        this.specialPower = new SpiderVenom(Constants.SPIDER_VENOM_DAMAGE + this.getHealth() / 10);
        this.specialPowerCastChance = Constants.MAGE_CAST_SPECIAL_CHANCE;
    }

    @Override
    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    @Override
    public int getSpecialPowerCastChance() {
        return specialPowerCastChance;
    }

    @Override
    public void castSpecial() {
        this.setDamageDealt(this.getSpecialPower().getDamage());
        this.setDamageDealtType(this.getSpecialPower().getType());
        Printer.giantSpiderCastSpecial(this.getName(), this.getSpecialPower().getName(),
                this.getSpecialPower().getDamage());
    }

    @Override
    public void attack() {
        this.dealDamage(this.getName(), this.getDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    @Override
    public void defense(int playerDamage, String playerDamageType) {
        this.takeDamage(this.getName(), playerDamage, playerDamageType);
    }
}