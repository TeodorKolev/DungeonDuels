package models;

import constants.Constants;
import interfaces.iAttackable;
import interfaces.iCastable;
import interfaces.iHurtable;
import models.spells.Cleave;

import java.util.Random;

public class Warrior extends Creature implements iAttackable, iHurtable, iCastable {

    private String name;
    private Cleave specialCast = new Cleave(this.getDamage() / 2);

    public Warrior(String name) {
        super(Constants.WARRIOR_HEALTH, Constants.WARRIOR_DAMAGE);
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

    @Override
    public void doDamage() {
        System.out.println(this.getName() + " deal " + this.getDamage() + " damage.");
        this.castSpecial();
    }

    @Override
    public void getDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
        System.out.println(this.getName() + " gets " + damage + " damage. Remaining life: " +
                this.getHealth() + " health.");
    }

    @Override
    public void castSpecial() {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        if (randomInt <= Constants.WARRIOR_CAST_SPECIAL_CHANCE) {
            System.out.println(this.getName() + " cast " + this.getSpecialCast().getName() + " deal " +
                    this.getSpecialCast().getDamage() + " damage");
        }

    }
}
