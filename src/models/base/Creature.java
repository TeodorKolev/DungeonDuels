package models.base;

public class Creature extends Entity {

    private int health;
    private int damage;
    private int defence;

    public Creature(String name, int health, int damage, int defence) {
        super(name);
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

    public void getDamage(String name, int damage) {
        this.setHealth(this.getHealth() - damage);
        System.out.println(name + " gets " + damage + " damage. Remaining life: " +
                this.getHealth() + " health.");
    }

    public void doDamage(String name, int damage) {
        System.out.println(name + " deal " + damage + " damage.");
    }
}
