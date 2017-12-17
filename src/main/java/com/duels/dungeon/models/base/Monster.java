package com.duels.dungeon.models.base;


public abstract class Monster extends Creature {

    public Monster(String name, int health, int damage, int defence) {
        super(name, health, damage, defence);
    }

    public abstract void attack();

    public abstract void defense(int playerDamage, String playerDamageType);

}

