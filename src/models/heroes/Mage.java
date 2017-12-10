package models.heroes;

import models.base.Player;
import models.base.SpecialPower;
import utils.Constants;
import interfaces.iCastable;
import models.base.Creature;
import models.spells.LightingBold;
import utils.Printer;

public class Mage extends Player implements iCastable {

    private String name;
    private Creature creature;
    private SpecialPower lightingBold;

    public Mage(String name) {
        super(name);
        this.creature = new Creature(Constants.MAGE, Constants.MAGE_HEALTH, Constants.MAGE_DAMAGE, Constants.MAGE_DEFENSE);
        this.lightingBold = new LightingBold();
    }

    public Creature getCreature() {
        return creature;
    }

    public String getName() {
        return name;
    }

    @Override
    public void attack() {
        this.getCreature().dealDamage(this.getName(),
                this.getCreature().getDamage(), this.getCreature().getDamageDealtType());
    }

    @Override
    public void defense(int monsterDamage, String monsterDamageType) {
        this.getCreature().takeDamage(this.getName(),
                monsterDamage, monsterDamageType);
    }

    @Override
    public void replenishLife() {
        this.getCreature().setHealth(Constants.MAGE_HEALTH);
    }

    @Override
    public Class getClassInstance() {
        return this.getClass();
    }

    @Override
    public SpecialPower getSpecialPower() {
        return lightingBold;
    }

    @Override
    public int getSpecialPowerCastChance() {
        return Constants.MAGE_CAST_SPECIAL_CHANCE;
    }

    @Override
    public void castSpecial() {
        this.getCreature().setDamageDealt(this.getSpecialPower().getDamage());
        this.getCreature().setDamageDealtType(this.getSpecialPower().getType());
        Printer.mageCastSpecial(this.getName(), this.getSpecialPower().getName(), this.getCreature().getDamageDealt());

    }


}
