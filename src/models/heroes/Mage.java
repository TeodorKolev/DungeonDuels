package models.heroes;

import models.base.Player;
import models.base.SpecialPower;
import utils.Constants;
import interfaces.ISpellCaster;
import models.spells.LightningBold;
import utils.Printer;

public class Mage extends Player implements ISpellCaster {

    private String name;
    private SpecialPower specialPower;
    private int specialPowerCastChance;

    public Mage(String name) {
        super(name, Constants.MAGE_HEALTH, Constants.MAGE_DAMAGE, Constants.MAGE_DEFENSE);
        this.name = name;
        this.specialPower = new LightningBold();
        this.specialPowerCastChance = Constants.MAGE_CAST_SPECIAL_CHANCE;
    }

    public String getName() {
        return name;
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
        this.setHealth(Constants.MAGE_HEALTH);
    }

    @Override
    public SpecialPower getSpecialPower() {
        return specialPower;
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


}
