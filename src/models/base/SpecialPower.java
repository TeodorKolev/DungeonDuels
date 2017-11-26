package models.base;

public class SpecialPower {

    private String name;

    private String type;

    private int damage;

    public SpecialPower(String name, String type, int damage) {
        this.name = name;
        this.type = type;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
