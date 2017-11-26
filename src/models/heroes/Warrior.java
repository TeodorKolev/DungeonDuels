package models.heroes;

import constants.Constants;
import interfaces.iCastable;
import models.base.DamageBonusCreature;
import models.spells.Cleave;

import java.util.Random;

public class Warrior extends DamageBonusCreature implements iCastable {

    private String name;
    private Cleave specialCast = new Cleave(this.getDamage() / 2);

    public Warrior(String name) {
        super(Constants.WARRIOR_HEALTH, Constants.WARRIOR_DAMAGE, Constants.WARRIOR_DEFENCE);
        this.name = name;
    }

    private Cleave getSpecialCast() {
        return specialCast;
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doDamage() {
        this.addBonusDamage(this.getName(), this.getDamage(),
                Constants.WARRIOR_DAMAGE_BONUS_POINT, Constants.WARRIOR_DAMAGE_BONUS_CHANCE);
        this.castSpecial(Constants.WARRIOR_CAST_SPECIAL_CHANCE);
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
