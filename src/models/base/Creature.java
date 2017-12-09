package models.base;

import utils.Constants;
import utils.Printer;

public class Creature extends Entity {

    private int health;
    private int damage;
    private int defense;
    private int damageDealt;
    private int damageTaken;
    private String damageDealtType;
    private String damageTakenType;

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

    public String getDamageTakenType() {
        return damageTakenType;
    }

    private void setDamageTakenType(String damageTakenType) {
        this.damageTakenType = damageTakenType;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(int damageDealt) {
        this.damageDealt = damageDealt;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    private void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    private int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    protected int takeDamage() {
        return damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    protected void takeDamage(String name, int damage, String damageType) {
        int damageReduced;
        if (damageType.equals(Constants.DAMAGE_TYPE_PHYSICAL)) {
            damageReduced = (damage - this.getDefense());
            this.setDamageTaken(damageReduced);
            this.setHealth(this.getHealth() - damageReduced);
            this.setDamageTakenType(damageType);
            Printer.takeDamage(name, damageReduced, this.getHealth());
        } else  if (damageType.equals(Constants.DAMAGE_TYPE_MAGIC)) {
            this.setDamageTaken(damage);
            this.setHealth(this.getHealth() - damage);
            this.setDamageTakenType(damageType);
            Printer.takeDamage(name, damage, this.getHealth());
        }
    }

    protected void dealDamage(String name, int damage, String damageType) {
        this.setDamageDealt(damage);
        this.setDamageDealtType(damageType);
        Printer.dealDamage(name, damage);
    }
}
