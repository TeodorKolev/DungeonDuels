package models.base;

import utils.Printer;

import java.util.Random;

public class DamageBonusCreature extends Creature {

    public DamageBonusCreature(String name, int health, int damage, int defense) {
        super(name, health, damage, defense);
    }

    protected void addBonusDamage(String name, int baseDamage, int bonusPoint, int chance, String damageType) {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        if (randomInt <= chance) {
            baseDamage += bonusPoint;
        }
        if (randomInt <= (chance * 2)) {
            baseDamage += bonusPoint;
        }
        this.setDamageDealt(baseDamage);
        this.setDamageDealtType(damageType);
        Printer.dealDamage(name, baseDamage);
    }

}
