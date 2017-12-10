package models.heroes;

import interfaces.IBonusDamager;
import models.base.Player;
import models.base.SpecialPower;
import models.spells.Cleave;
import utils.Constants;
import interfaces.ISpellCaster;
import utils.Printer;

public class Warrior extends Player implements ISpellCaster, IBonusDamager {

    private SpecialPower cleave;
    private int specialPowerCastChance;
    private int bonusDamageChance;

    public Warrior(String name) {
        super (name, Constants.WARRIOR_HEALTH, Constants.WARRIOR_DAMAGE, Constants.WARRIOR_DEFENSE);
        this.cleave = new Cleave(this.getDamage() / 2);
        this.specialPowerCastChance = Constants.WARRIOR_CAST_SPECIAL_CHANCE;
        this.bonusDamageChance = Constants.WARRIOR_DAMAGE_BONUS_CHANCE;
    }

    public int getBonusDamageChance() {
        return bonusDamageChance;
    }

    @Override
    public void attack() {
        this.dealDamage(this.getName(), this.getDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    @Override
    public void defense(int monsterDamage, String monsterDamageType) {
        this.takeDamage(this.getName(),
                monsterDamage, monsterDamageType);
    }

    @Override
    public void replenishLife() {
        this.setHealth(Constants.WARRIOR_HEALTH);
    }

    @Override
    public SpecialPower getSpecialPower() {
        return cleave;
    }

    @Override
    public int getSpecialPowerCastChance() {
        return specialPowerCastChance;
    }

    @Override
    public void castSpecial() {
        this.setDamageDealt(this.getSpecialPower().getDamage());
        this.setDamageDealtType(this.getSpecialPower().getType());
        Printer.warriorCastSpecial(this.getName(), this.getSpecialPower().getName(), this.getSpecialPower().getDamage());
    }

    @Override
    public void empowerAttack(int chance) {
        if (chance <= (this.getBonusDamageChance() * 2)) {
            this.setDamage(this.getDamage() + Constants.WARRIOR_DAMAGE_BONUS_POINT);
            if (chance <= this.getBonusDamageChance()) {
                this.setDamage(this.getDamage() + Constants.WARRIOR_DAMAGE_BONUS_POINT);
            }
        }
        else {
            this.resetDamage();
        }
        this.attack();
    }

    @Override
    public void resetDamage() {
        this.setDamage(Constants.WARRIOR_DAMAGE);
    }
}
