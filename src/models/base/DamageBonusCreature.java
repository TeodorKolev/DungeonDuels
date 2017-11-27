package models.base;

import java.util.Random;

public class DamageBonusCreature extends Creature {

    public DamageBonusCreature(String name, int health, int damage, int defence) {
        super(name, health, damage, defence);
    }

    public void addBonusDamage(String name, int baseDamage, int bonusPoint, int chance, String damageType) {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        if (randomInt <= chance) {
            baseDamage += bonusPoint;
        }
        if (randomInt <= (chance * 2)) {
            baseDamage += bonusPoint;
        }
        this.setDamageDone(baseDamage);
        this.setDamageDoneType(damageType);
        System.out.println(name + " deal " + baseDamage + " damage.");
    }

}