package models.base;

import utils.Constants;
import utils.Printer;

public class Creature extends Entity {

    private int health;
    private int damage;
    private int defense;
    private int damageDealt;
    private String damageDealtType;

    public Creature(String name, int health, int damage, int defense) {
        super(name);
        this.health = health;
        this.damage = damage;
        this.defense = defense;
    }

    public String getDamageDealtType() {
        return damageDealtType;
    }

    public void setDamageDealtType(String damageDealtType) {
        this.damageDealtType = damageDealtType;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    protected void setDamageDealt(int damageDealt) {
        this.damageDealt = damageDealt;
    }

    protected int getDefense() {
        return defense;
    }

    protected int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    protected void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    protected void takeDamage(String name, int damage, String damageType) {
        int damageReduced;
        if (damageType.equals(Constants.DAMAGE_TYPE_PHYSICAL)) {
            damageReduced = (damage - this.getDefense());
            this.setHealth(this.getHealth() - damageReduced);
            Printer.takeDamage(name, damageReduced, this.getHealth());
        } else  if (damageType.equals(Constants.DAMAGE_TYPE_MAGIC)) {
            this.setHealth(this.getHealth() - damage);
            Printer.takeDamage(name, damage, this.getHealth());
        }
    }

    protected void dealDamage(String name, int damage, String damageType) {
        this.setDamageDealt(damage);
        this.setDamageDealtType(damageType);
        Printer.dealDamage(name, damage);
    }
}
