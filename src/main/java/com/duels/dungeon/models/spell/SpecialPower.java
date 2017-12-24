package com.duels.dungeon.models.spell;

import com.duels.dungeon.models.Entity;

/**
 * Represents an spell power.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class SpecialPower extends Entity {

    private String type;
    private int damage;

    /**
     * Creates an spell power with the specified name, type, and damage.
     * @param name The spell power's new name. Type String.
     * @param type The spell power's damage type. Type String.
     * @param damage The spell power's damage power. Type int.
     */
    public SpecialPower(String name, String type, int damage) {
        super(name);
        this.type = type;
        this.damage = damage;
    }

    /**
     * Creates an spell power with the specified name and type.
     * @param name The spell power's new name. Type String.
     * @param type The spell power's damage type. Type String.
     */
    public SpecialPower(String name, String type) {
        super(name);
        this.type = type;
    }

    /**
     * Creates an spell power with the specified name.
     * @param name The spell power's new name. Type String.
     */
    public SpecialPower(String name) {
        super(name);
    }

    /**
     * Retrieve spell power's damage.
     * @return spell power's damage. Type int.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Retrieve spell power's damage type.
     * @return spell power's damage type. Type int.
     */
    public String getType() {
        return type;
    }

}
