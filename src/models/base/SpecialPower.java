package models.base;

public class SpecialPower extends Entity {

    private String type;

    private int damage;

    public SpecialPower(String name, String type, int damage) {
        super(name);
        this.type = type;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
