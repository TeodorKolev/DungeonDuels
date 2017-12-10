package models.heroes;

import models.base.SpecialPower;
import models.spells.Cleave;
import utils.Constants;
import interfaces.ISpellCaster;
import models.base.DamageBonusCreature;
import utils.Printer;

public class Warrior extends DamageBonusCreature implements ISpellCaster {


    public Warrior() {
        super (Constants.WARRIOR, Constants.WARRIOR_HEALTH, Constants.WARRIOR_DAMAGE, Constants.WARRIOR_DEFENSE);
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
    public SpecialPower getSpecialPower() {
        return new Cleave(this.getDamage() / 2);
    }

    @Override
    public int getSpecialPowerCastChance() {
        return Constants.WARRIOR_CAST_SPECIAL_CHANCE;
    }

    @Override
    public void castSpecial() {
        this.setDamageDealt(this.getSpecialPower().getDamage());
        this.setDamageDealtType(this.getSpecialPower().getType());
        Printer.warriorCastSpecial(this.getName(), this.getSpecialPower().getName(), this.getSpecialPower().getDamage());
    }

}
