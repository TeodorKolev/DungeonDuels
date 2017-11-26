package models.heroes;

import constants.Constants;
import interfaces.iCastable;
import models.base.Creature;
import models.spells.LightingBold;

import java.util.Random;

public class Mage extends Creature implements iCastable {

    private String name;
    private LightingBold specialCast = new LightingBold();

    public Mage(String name) {
        super(Constants.MAGE_HEALTH, Constants.MAGE_DAMAGE, Constants.MAGE_DEFENCE);
        this.name = name;
    }

    private LightingBold getSpecialCast() {
        return specialCast;
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doDamage() {
        this.doDamage(this.getName(), this.getDamage());
        this.castSpecial(Constants.MAGE_CAST_SPECIAL_CHANCE);
    }

    public void getDamage(int damage) {
       this.getDamage(this.getName(), damage);
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
