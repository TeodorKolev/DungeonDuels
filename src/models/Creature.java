package models;

public class Creature {

    private int health;
    private int damage;
    private int defence;

    public Creature(int health, int damage, int defence) {
        this.health = health;
        this.damage = damage;
        this.defence = defence;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
