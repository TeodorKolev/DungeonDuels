package models.heroes;

import models.base.SpecialPower;
import utils.Constants;
import interfaces.iCastable;
import models.base.Creature;
import models.spells.LightingBold;
import utils.Printer;

public class Mage extends Creature implements iCastable {

    private LightingBold specialPower = new LightingBold();
    private int specialPowerCastChance;

    public Mage() {
        super("Mage", Constants.MAGE_HEALTH, Constants.MAGE_DAMAGE, Constants.MAGE_DEFENSE);
    }

    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    public int getSpecialPowerCastChance() {
        return Constants.WARRIOR_CAST_SPECIAL_CHANCE;
    }

    public void attack(String playerName) {
        this.dealDamage(playerName, this.takeDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    public void defense(String playerName, int damage, String damageType) {
       this.takeDamage(playerName, damage, damageType);
    }

    @Override
    public void castSpecial() {
        this.setDamageDealt(this.getSpecialPower().getDamage());
        this.setDamageDealtType(Constants.DAMAGE_TYPE_MAGIC);
        Printer.mageCastSpecial(this.getName(), this.getSpecialPower().getName(), this.getSpecialPower().getDamage());

    }
}
