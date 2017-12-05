package models.heroes;

import models.base.SpecialPower;
import utils.Constants;
import interfaces.iCastable;
import models.base.Creature;
import models.spells.LightingBold;
import utils.Printer;

public class Mage extends Creature implements iCastable {

    public Mage() {
        super(Constants.MAGE, Constants.MAGE_HEALTH, Constants.MAGE_DAMAGE, Constants.MAGE_DEFENSE);
    }

    public void attack(String playerName) {
        this.dealDamage(playerName, this.takeDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    public void defense(String playerName, int damage, String damageType) {
       this.takeDamage(playerName, damage, damageType);
    }

    @Override
    public SpecialPower getSpecialPower() {
        return new LightingBold();
    }

    @Override
    public int getSpecialPowerCastChance() {
        return Constants.MAGE_CAST_SPECIAL_CHANCE;
    }

    @Override
    public void castSpecial() {
        this.setDamageDealt(this.getSpecialPower().getDamage());
        this.setDamageDealtType(Constants.DAMAGE_TYPE_MAGIC);
        Printer.mageCastSpecial(this.getName(), this.getSpecialPower().getName(), this.getSpecialPower().getDamage());

    }
}
