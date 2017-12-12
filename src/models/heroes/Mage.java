package models.heroes;

import models.base.Player;
import models.base.SpecialPower;
import utils.Constants;
import interfaces.ISpellCaster;
import models.spells.LightningBold;
import utils.Printer;

public class Mage extends Player implements ISpellCaster {

    private SpecialPower specialPower;

    public Mage(String name) {
        super(name, Constants.MAGE_HEALTH, Constants.MAGE_DAMAGE, Constants.MAGE_DEFENSE);
        this.specialPower = new LightningBold();
    }

    @Override
    public void attack() {
        this.dealDamage(this.getName(), this.getDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    @Override
    public void defense(int monsterDamage, String monsterDamageType) {
        this.takeDamage(this.getName(), monsterDamage, monsterDamageType);
    }

    @Override
    public void replenishLife() {
        this.setHealth(Constants.MAGE_HEALTH);
    }

    @Override
    public SpecialPower getSpecialPower() {
        return this.specialPower;
    }

    @Override
    public int getSpecialPowerCastChance() {
        return Constants.MAGE_CAST_SPECIAL_CHANCE;
    }

    @Override
    public void castSpecial() {
        this.setDamageDealt(this.getSpecialPower().getDamage());
        this.setDamageDealtType(this.getSpecialPower().getType());
        Printer.mageCastSpecial(this.getName(), this.getSpecialPower().getName(), this.getSpecialPower().getDamage());
    }

}
