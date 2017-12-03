package models.base;

import models.monsters.Skeleton;

public class Monster extends Entity {

    private Creature creature;
    private SpecialPower specialPower;
    private int specialPowerCastChance;

    public Monster(Creature creature) {
        super("Monster");
        this.creature = creature;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    public int getSpecialPowerCastChance() {
        return specialPowerCastChance;
    }

    public void attack(){
        if(creature instanceof Skeleton) {
            ((Skeleton) creature).attack();
        }
    }

    public void defense(int damage, String damageType) {
        if(creature instanceof Skeleton){
            ((Skeleton) creature).defense(damage, damageType);
        }
    }

    public void castSpecial() {
    }

}
