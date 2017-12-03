package models.heroes;

import models.base.SpecialPower;
import utils.Constants;
import interfaces.iCastable;
import models.base.DamageBonusCreature;
import models.spells.Cleave;
import utils.Printer;

public class Warrior extends DamageBonusCreature implements iCastable {

    private Cleave specialPower = new Cleave(this.takeDamage() / 2);
    private int specialPowerCastChance;

    public Warrior() {
        super ("Warrior", Constants.WARRIOR_HEALTH, Constants.WARRIOR_DAMAGE, Constants.WARRIOR_DEFENSE);
    }

    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    public int getSpecialPowerCastChance() {
        return Constants.WARRIOR_CAST_SPECIAL_CHANCE;
    }

    public void attack(String playerName) {
        this.addBonusDamage(playerName,
                this.takeDamage(),
                Constants.WARRIOR_DAMAGE_BONUS_POINT,
                Constants.WARRIOR_DAMAGE_BONUS_CHANCE,
                Constants.DAMAGE_TYPE_PHYSICAL);
    }

    public void defense(String playerName, int damage, String damageType) {
        this.takeDamage(playerName, damage, damageType);
    }

    @Override
    public void castSpecial() {
        this.setDamageDealt(this.getSpecialPower().getDamage());
        this.setDamageDealtType(Constants.DAMAGE_TYPE_MAGIC);
        Printer.warriorCastSpecial(this.getName(), this.getSpecialPower().getName(), this.getSpecialPower().getDamage());
}

}
