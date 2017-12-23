package com.duels.dungeon.models.creature.player.heroes;

import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.spell.SpecialPower;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.models.creature.SpellCastable;
import com.duels.dungeon.models.spell.spells.LightningBold;
import com.duels.dungeon.utils.Printer;

public class Mage extends Player implements SpellCastable {

    private SpecialPower specialPower;
    private String name;

    public Mage(String name) {
        super(Constants.MAGE, Constants.MAGE_HEALTH, Constants.MAGE_DAMAGE, Constants.MAGE_DEFENSE);
        this.specialPower = new LightningBold();
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
        this.takeDamage(this.getName(), monsterDamage, monsterDamageType);
    }

    @Override
    public void replenishLife() {
        this.setHealth(Constants.MAGE_HEALTH);
    }

    @Override
    public SpecialPower getSpecialPower() {
        return this.specialPower;
    }

    @Override
    public int getSpecialPowerCastChance() {
        return Constants.MAGE_CAST_SPECIAL_CHANCE;
    }

    @Override
    public void castSpecial() {
        Printer.castSpecial(this.getName(), this.getSpecialPower().getName());
        this.dealDamage(this.getName(), this.getSpecialPower().getDamage(), this.getSpecialPower().getType());
    }

}
