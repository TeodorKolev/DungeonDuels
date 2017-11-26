package models.heroes;

import constants.Constants;
import interfaces.iCastable;
import models.base.DamageBonusCreature;
import models.spells.Cleave;

import java.util.Random;

public class Warrior extends DamageBonusCreature implements iCastable {

    private Cleave specialCast = new Cleave(this.getDamage() / 2);

    public Warrior() {
        super ("Warrior", Constants.WARRIOR_HEALTH, Constants.WARRIOR_DAMAGE, Constants.WARRIOR_DEFENCE);
    }

    private Cleave getSpecialCast() {
        return specialCast;
    }

    public void attack(String playerName) {
        this.addBonusDamage(playerName, this.getDamage(),
                Constants.WARRIOR_DAMAGE_BONUS_POINT, Constants.WARRIOR_DAMAGE_BONUS_CHANCE);
        this.castSpecial(Constants.WARRIOR_CAST_SPECIAL_CHANCE);
    }

    public void defense(String playerName, int damage) {
        this.getDamage(playerName, damage);
    }

    @Override
    public void castSpecial(int chance) {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        if (randomInt <= chance) {
            System.out.println(this.getName() + " cast " + this.getSpecialCast().getName() + " deal " +
                    this.getSpecialCast().getDamage() + " damage");
        }

    }

}
