package models;

public class Mage extends Creature implements iAttackable, iHurtable, iCastable {

    private String name;
    private LightingBold specialCast = new LightingBold();

    public Mage(String name) {
        super(20, 2);
        this.name = name;
    }

    private LightingBold getSpecialCast() {
        return specialCast;
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doDamage(int damage) {
        return damage;
    }

    @Override
    public int getDamage(int damage) {
        return damage;
    }

    @Override
    public void castSpecial() {
        System.out.println(this.getName() + " cast " + this.getSpecialCast().getName() + " deal " +
                this.getSpecialCast().getDamage() + " damage");
    }
}
