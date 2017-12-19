package com.duels.dungeon.models.heroes;

import com.duels.dungeon.models.base.BonusDamagеable;
import com.duels.dungeon.models.base.Player;
import com.duels.dungeon.models.base.SpecialPower;
import com.duels.dungeon.models.spells.Cleave;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.models.base.SpellCastable;
import com.duels.dungeon.utils.Printer;

public class Warrior extends Player implements SpellCastable, BonusDamagеable {

    private SpecialPower specialPower;
    private String name;

    public Warrior(String name) {
        super (Constants.WARRIOR, Constants.WARRIOR_HEALTH, Constants.WARRIOR_DAMAGE, Constants.WARRIOR_DEFENSE);
        this.specialPower = new Cleave(this.getDamage() / 2);
        this.name = name;
    }

    @Override
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
        this.setHealth(Constants.WARRIOR_HEALTH);
    }

    @Override
    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    @Override
    public int getSpecialPowerCastChance() {
        return Constants.WARRIOR_CAST_SPECIAL_CHANCE;
    }

    @Override
    public void castSpecial() {
        Printer.castSpecial(this.getName(), this.getSpecialPower().getName());
        this.dealDamage(this.getName(), this.getSpecialPower().getDamage(), this.getSpecialPower().getType());
    }

    @Override
    public void empowerAttack(int chance) {
        if (chance <= Constants.WARRIOR_DAMAGE_BONUS_CHANCE) {
            this.setDamage(this.getDamage() + Constants.WARRIOR_DAMAGE_BONUS_POINT);
        }
        if (chance <= (Constants.WARRIOR_DAMAGE_BONUS_CHANCE * 2)) {
            this.setDamage(this.getDamage() + Constants.WARRIOR_DAMAGE_BONUS_POINT);
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
