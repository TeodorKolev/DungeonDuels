package models.base;

import models.heroes.Mage;
import models.heroes.Warrior;
import utils.Constants;


public class Player extends Entity {

    private Creature creature;
    private SpecialPower specialPower;
    private int specialPowerCastChance;

    public Player(String name, Creature creature) {
        super(name);
        this.creature = creature;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public SpecialPower getSpecialPower() {
        if (creature instanceof Warrior) {
            specialPower =  ((Warrior) creature).getSpecialPower();
        } else if(creature instanceof Mage){
            specialPower =  ((Mage) creature).getSpecialPower();
        }
        return specialPower;
    }

    public int getSpecialPowerCastChance() {
        if (creature instanceof Warrior) {
            specialPowerCastChance =  ((Warrior) creature).getSpecialPowerCastChance();
        } else if(creature instanceof Mage){
            specialPowerCastChance =  ((Mage) creature).getSpecialPowerCastChance();
        }
        return specialPowerCastChance;
    }

    public void attack(){
        if (creature instanceof Warrior) {
            ((Warrior) creature).attack(this.getName());
        } else if(creature instanceof Mage){
            ((Mage) creature).attack(this.getName());
        }
    }

    public void defense(int damage, String damageType) {
        if (creature instanceof Warrior){
            ((Warrior) creature).defense(this.getName(), damage, damageType);
        }
    }

    public void castSpecial(){
        if (creature instanceof Warrior) {
            ((Warrior) creature).castSpecial();
        } else if (creature instanceof Mage) {
            ((Mage) creature).castSpecial();
        }
    }

    public void replenishLife() {
        if (creature instanceof Warrior) {
            ((Warrior) creature).setHealth(Constants.WARRIOR_HEALTH);
        } else if (creature instanceof Mage) {
            ((Mage) creature).setHealth(Constants.MAGE_HEALTH);
        }
    }

}
