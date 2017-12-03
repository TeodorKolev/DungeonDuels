package models.base;

import models.heroes.Cleric;
import models.heroes.Mage;
import models.heroes.Warrior;
import utils.Constants;

import java.util.Random;

public class Player extends Entity {

    private Creature creature;
    private SpecialPower specialPower;

    public Player(String name, Creature creature) {
        super(name);
        this.creature = creature;
    }

    public Creature getCreature() {
        return creature;
    }

    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(SpecialPower specialPower) {
        this.specialPower = specialPower;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
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
            this.setSpecialPower(((Warrior) creature).getSpecialCast());
            ((Warrior) creature).castSpecial(Constants.WARRIOR_CAST_SPECIAL_CHANCE);
        } else if (creature instanceof Mage) {
            this.setSpecialPower(((Mage) creature).getSpecialCast());
            ((Mage) creature).castSpecial(Constants.MAGE_CAST_SPECIAL_CHANCE);
        }
    }

    public int getSpecialChance() {
        int chance = 0;
        if (creature instanceof Warrior) {
            chance = Constants.WARRIOR_CAST_SPECIAL_CHANCE;
        } else if(creature instanceof Mage){
            chance = Constants.MAGE_CAST_SPECIAL_CHANCE;
        }
        return chance;
    }

}
