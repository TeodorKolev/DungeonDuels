package models.base;

import models.heroes.Cleric;
import models.heroes.Mage;
import models.heroes.Warrior;

public class Player extends Entity {

    private Creature creature;

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

    public void attack(){
        if(creature instanceof Warrior){
            ((Warrior) creature).attack(this.getName());
        } else if(creature instanceof Mage){
            ((Mage) creature).attack(this.getName());
        }
    }

}
