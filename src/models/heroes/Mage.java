package models.heroes;

import models.base.SpecialPower;
import utils.Constants;
import interfaces.iCastable;
import models.base.Creature;
import models.spells.LightingBold;
import utils.Printer;

import java.util.Random;

public class Mage extends Creature implements iCastable {

    private LightingBold specialCast = new LightingBold();

    public Mage() {
        super("Mage", Constants.MAGE_HEALTH, Constants.MAGE_DAMAGE, Constants.MAGE_DEFENSE);
    }

    public SpecialPower getSpecialCast() {
        return specialCast;
    }

    public void attack(String playerName) {
        this.dealDamage(playerName, this.takeDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
        this.castSpecial(Constants.MAGE_CAST_SPECIAL_CHANCE);
    }

    public void defense(String playerName, int damage, String damageType) {
       this.takeDamage(playerName, damage, damageType);
    }

    @Override
    public void castSpecial(int chance) {
        this.setDamageDealt(this.getSpecialCast().getDamage());
        this.setDamageDealtType(Constants.DAMAGE_TYPE_MAGIC);
        Printer.mageCastSpecial(this.getName(), this.getSpecialCast().getName(), this.getSpecialCast().getDamage());

    }
}
