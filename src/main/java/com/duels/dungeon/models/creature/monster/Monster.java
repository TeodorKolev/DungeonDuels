package com.duels.dungeon.models.creature.monster;


import com.duels.dungeon.models.creature.Creature;

public abstract class Monster extends Creature {

    public Monster(String name, int health, int damage, int defence) {
        super(name, health, damage, defence);
    }

    public abstract void attack();

    public abstract void defense(int playerDamage, String playerDamageType);

}
