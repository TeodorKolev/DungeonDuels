package models.heroes;

import interfaces.ISpellCaster;
import models.base.Player;
import models.base.SpecialPower;
import models.spells.SoulTrade;
import utils.Constants;
import utils.Printer;

import java.util.Random;

public class Warlock extends Player implements ISpellCaster {

    private SpecialPower specialPower;

    public Warlock(String name) {
        super(name, Constants.WARLOCK_HEALTH, Constants.WARLOCK_DAMAGE, Constants.WARLOCK_DEFENSE);
        this.specialPower = new SoulTrade();
    }

    @Override
    public void attack() {
        this.dealDamage(this.getName(), this.getDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    @Override
    public void defense(int monsterDamage, String monsterDamageType) {
        this.takeDamage(this.getName(), monsterDamage, monsterDamageType);
    }

    @Override
    public void replenishLife() {
        this.setHealth(Constants.WARLOCK_HEALTH);
    }

    @Override
    public SpecialPower getSpecialPower() {
        return this.specialPower;
    }

    @Override
    public int getSpecialPowerCastChance() {
        return Constants.WARLOCK_CAST_SPECIAL_CHANCE;
    }

    @Override
    public void castSpecial() {
        this.setDamageTaken(Constants.WARLOCK_CAST_SPECIAL_PENALTY);
        Printer.soulTradePenalty(this.getName(), this.getSpecialPower().getName(), Constants.WARLOCK_CAST_SPECIAL_PENALTY);
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        if (randomInt <= this.getSpecialPowerCastChance()) {
            this.setDamageDealt(this.getSpecialPower().getDamage());
            this.setDamageDealtType(this.getSpecialPower().getType());
            Printer.warlockCastSpecial(this.getName(), this.getSpecialPower().getName(), this.getSpecialPower().getDamage());
        }
    }

}
