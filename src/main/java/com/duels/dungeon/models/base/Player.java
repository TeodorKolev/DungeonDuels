package main.java.com.duels.dungeon.models.base;

public abstract class Player extends Creature {

    public Player(String name, int health, int damage, int defence) {
        super(name, health, damage, defence);
    }

    public abstract void attack();

    public abstract void defense(int damage, String damageType);

    public abstract void replenishLife();

}
