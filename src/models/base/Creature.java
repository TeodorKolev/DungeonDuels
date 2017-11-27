package models.base;

import utils.Constants;

public class Creature extends Entity {

    private int health;
    private int damage;
    private int defence;
    private int damageDealt;
    private int damageTaken;
    private String damageDealtType;
    private String damageTakenType;

    public Creature(String name, int health, int damage, int defence) {
        super(name);
        this.health = health;
        this.damage = damage;
        this.defence = defence;
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

    public void setDamageTakenType(String damageTakenType) {
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

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int takeDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void takeDamage(String name, int damage, String damageType) {
        int damageReduced;
        if (damageType.equals(Constants.DAMAGE_TYPE_PHYSICAL)) {
            damageReduced = (damage - this.getDefence());
            this.setHealth(this.getHealth() - damageReduced);
            this.setDamageTaken(damageReduced);
            this.setDamageTakenType(damageType);
            System.out.println(name + " gets " + damageReduced + " damage. Remaining life: " +
                    this.getHealth() + " health.");
        } else  if (damageType.equals(Constants.DAMAGE_TYPE_MAGIC)) {
            this.setDamageTaken(damage);
            System.out.println(name + " gets " + damage + " damage. Remaining life: " +
                    this.getHealth() + " health.");
        }
    }

    public void dealDamage(String name, int damage, String damageType) {
        this.setDamageDealt(damage);
        this.setDamageDealtType(damageType);
        System.out.println(name + " deal " + damage + " damage.");
    }
}
