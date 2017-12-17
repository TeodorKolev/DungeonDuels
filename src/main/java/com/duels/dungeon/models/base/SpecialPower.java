package com.duels.dungeon.models.base;

public class SpecialPower extends Entity {

    private String type;
    private int damage;

    public SpecialPower(String name, String type, int damage) {
        super(name);
        this.type = type;
        this.damage = damage;
    }

    public SpecialPower(String name, String type) {
        super(name);
        this.type = type;
    }

    public SpecialPower(String name) {
        super(name);
    }

    public int getDamage() {
        return damage;
    }

    public String getType() {
        return type;
    }

}