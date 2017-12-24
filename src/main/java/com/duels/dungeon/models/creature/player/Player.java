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
     * @param name The player's new name. Type String.
     * @param health The player's health points. Type int.
     * @param damage The player's damage power. Type int.
     * @param defense The player's defense power. Type int
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
