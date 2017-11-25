package models;

import interfaces.iAttackable;
import interfaces.iCastable;
import interfaces.iHurtable;

public class Mage extends Creature implements iAttackable, iHurtable, iCastable {

    private String name;
    private LightingBold specialCast = new LightingBold();

    public Mage(String name) {
        super(20, 2);
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

    @Override
    public void doDamage(int damage) {
        System.out.println(this.getName() + " deal " + damage + " damage.");
    }

    @Override
    public void getDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
        System.out.println(this.getName() + " gets " + damage + " damage. Remaining life: " +
                this.getHealth() + " health.");
    }

    @Override
    public void castSpecial() {
        System.out.println(this.getName() + " cast " + this.getSpecialCast().getName() + " deal " +
                this.getSpecialCast().getDamage() + " damage");
    }
}
