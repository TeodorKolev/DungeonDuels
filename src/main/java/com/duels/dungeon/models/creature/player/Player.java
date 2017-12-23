package com.duels.dungeon.models.creature.player;

import com.duels.dungeon.models.creature.Creature;

/**
 * Represents an player. An abstract class.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public abstract class Player extends Creature {

    /** Creates an player with the specified name, health, damage and defense.
     * @param name from type String. The creature's new name.
     * @param health from type int. The creature's health points.
     * @param damage from type int. The creature's damage power.
     * @param defense from type String. The creature's defense power.
     */
    public Player(String name, int health, int damage, int defense) {
        super(name, health, damage, defense);
    }

    /** Player attack action. Abstract method that child must implements.
     */
    public abstract void attack();


    /** Player defense action. Abstract method that child must implements.
     * @param damage Damage taken by the player. Type int
     * @param damage Damage type of damage taken by the player. Type String.
     */
    public abstract void defense(int damage, String damageType);

    /** Restoring player's life action. Abstract method that child must implements.
     */
    public abstract void replenishLife();

}
