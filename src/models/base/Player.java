package models.base;

public abstract class Player extends Creature {

    public Player(String name) {
        super(name);
    }

    public abstract void attack();

    public abstract void defense(int damage, String damageType);

    public abstract void replenishLife();

}
