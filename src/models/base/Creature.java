package models.base;

public class Creature extends Entity {

    private int health;
    private int damage;
    private int defence;
    private int damageDone;
    private int damageTaken;

    public Creature(String name, int health, int damage, int defence) {
        super(name);
        this.health = health;
        this.damage = damage;
        this.defence = defence;
    }

    public int getDamageDone() {
        return damageDone;
    }

    public void setDamageDone(int damageDone) {
        this.damageDone = damageDone;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
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
        int damageReduced = (damage - (this.getDefence() / 2));
        this.setHealth(this.getHealth() - damageReduced);
        this.setDamageTaken(damageReduced);
        System.out.println(name + " gets " + damageReduced + " damage. Remaining life: " +
                this.getHealth() + " health.");
    }

    public void doDamage(String name, int damage, String damageType) {
        this.setDamageDone(damage);
        System.out.println(name + " deal " + damage + " damage.");
    }
}
