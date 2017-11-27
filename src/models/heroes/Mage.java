package models.heroes;

import utils.Constants;
import interfaces.iCastable;
import models.base.Creature;
import models.spells.LightingBold;

import java.util.Random;

public class Mage extends Creature implements iCastable {

    private LightingBold specialCast = new LightingBold();

    public Mage() {
        super("Mage", Constants.MAGE_HEALTH, Constants.MAGE_DAMAGE, Constants.MAGE_DEFENCE);
    }

    private LightingBold getSpecialCast() {
        return specialCast;
    }

    public void attack(String playerName) {
        this.dealDamage(playerName, this.takeDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
        this.castSpecial(Constants.MAGE_CAST_SPECIAL_CHANCE);
    }

    public void defence(String playerName, int damage, String damageType) {
       this.takeDamage(playerName, damage, damageType);
    }

    @Override
    public void castSpecial(int chance) {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        if (randomInt <= chance) {
            System.out.println(this.getName() + " cast " + this.getSpecialCast().getName() + " deal " +
                    this.getSpecialCast().getDamage() + " damage");
        }

    }
}
