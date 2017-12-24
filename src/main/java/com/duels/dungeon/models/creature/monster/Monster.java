package com.duels.dungeon.models.creature.monster;


import com.duels.dungeon.models.creature.Creature;

/**
 * Represents an monster. An abstract class.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public abstract class Monster extends Creature {

    /**
     * Creates an monster with the specified name, health, damage and defense.
     * @param name The monster's new name. Type String.
     * @param health The monster's health points. Type int.
     * @param damage The monster's damage power. Type int.
     * @param defense The monster's defense power. Type int
     */
    public Monster(String name, int health, int damage, int defense) {
        super(name, health, damage, defense);
    }


    /**
     * Monster attack action. Abstract method that child must implements.
     */
    public abstract void attack();

    /**
     * Monster defense action. Abstract method that child must implements.
     * @param playerDamage Damage taken by the monster. Type int
     * @param playerDamageType Damage type of damage taken by the monster. Type String.
     */
    public abstract void defense(int playerDamage, String playerDamageType);

}

