package models.base;

public class SpecialPower extends Entity {

    private String type;
    private int damage;
    private String target;

    public SpecialPower(String name, String type, int damage, String target) {
        super(name);
        this.type = type;
        this.damage = damage;
        this.target = target;
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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}
