package com.duels.dungeon.models.creature;

import com.duels.dungeon.models.Entity;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.utils.Printer;

/**
 * Represents an creature.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class Creature extends Entity {

    private int health;
    private int damage;
    private int defense;
    private int damageDealt;
    private String damageDealtType;

    /** Creates an creature with the specified name, health, damage and defence.
     * @param name from type String. The creature's new name.
     * @param health from type int. The creature's health points.
     * @param damage from type int. The creature's damage power.
     * @param defense from type String. The creature's defence power.
     */
    public Creature(String name, int health, int damage, int defense) {
        super(name);
        this.health = health;
        this.damage = damage;
        this.defense = defense;
    }

    /**
     * Retrieve current creature's damage dealt type.
     * @return creature's damage dealt type. Type String.
     */
    public String getDamageDealtType() {
        return damageDealtType;
    }

    /**
     * Changes creature's damage dealt type.
     * @param damageDealtType Creature's new damage dealt type. Type String.
     */
    public void setDamageDealtType(String damageDealtType) {
        this.damageDealtType = damageDealtType;
    }

    /**
     * Retrieve current creature's damage dealt.
     * @return Creature's damage dealt type. Type String.
     */
    public int getDamageDealt() {
        return damageDealt;
    }

    /**
     * Changes creature's damage dealt.
     * @param damageDealt Creature's new damage dealt. Type int.
     */
    protected void setDamageDealt(int damageDealt) {
        this.damageDealt = damageDealt;
    }

    /**
     * Retrieve current creature's defence.
     * @return creature's defence. Type int.
     */
    protected int getDefense() {
        return defense;
    }

    /**
     * Retrieve current Creature's health.
     * @return Creature's current health. Type int.
     */
    protected int getHealth() {
        return health;
    }

    /**
     * Changes creature's health.
     * @param health Creature's new health. Type int.
     */
    protected void setHealth(int health) {
        this.health = health;
    }

    /**
     * Retrieve current creature's damage.
     * @return Creature's damage. Type int.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Changes creature's damage.
     * @param damage Creature's new damage. Type int.
     */
    protected void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Define does current creature's has at least 1 health life.
     * @return boolean data type true if current Creature has at least one health point life
     * or boolean data type false if current Creature has less than one health point life.
     */
    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    /**
     * Reduce the creature's life according to incoming damage type and prints the result.
     * If incoming damage type is physical - damage will be reduced by subtracting Creature's defence from it.
     * If incoming damage type is magical - damage will not be reduced.
     * @param name Name of creature that has taken damage. Type String.
     * @param damage Incoming damage. Type int.
     * @param damageType Incoming damage type. Type int.
     */
    protected void takeDamage(String name, int damage, String damageType) {
        int damageReduced;
        if (damageType.equals(Constants.DAMAGE_TYPE_PHYSICAL)) {
            damageReduced = (damage - this.getDefense());
            this.setHealth(this.getHealth() - damageReduced);
            Printer.takeDamage(name, damageReduced, this.getHealth());
        } else if (damageType.equals(Constants.DAMAGE_TYPE_MAGIC)) {
            this.setHealth(this.getHealth() - damage);
            Printer.takeDamage(name, damage, this.getHealth());
        }
    }

    /**
     * Sets the creature's damage dealt, type of damage dealt and prints the result.
     * @param name Name of creature that deal damage. Type String.
     * @param damage Creature's damage dealt. Type int.
     * @param damageType Creature's damage dealt type. Type String.
     */
    protected void dealDamage(String name, int damage, String damageType) {
        this.setDamageDealt(damage);
        this.setDamageDealtType(damageType);
        Printer.dealDamage(name, damage);
    }
}
