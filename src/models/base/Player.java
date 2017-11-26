package models.base;

import models.heroes.Cleric;
import models.heroes.Mage;
import models.heroes.Warrior;

public class Player {

    private Creature creature;

    private String name;

    public Player(Creature creature){
        this.creature = creature;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doDamage(){
        if(creature instanceof Warrior){
            ((Warrior) creature).doDamage();
        } else if(creature instanceof Mage){
            ((Mage) creature).doDamage();
        }
    }

}
