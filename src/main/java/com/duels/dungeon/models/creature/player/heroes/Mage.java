package com.duels.dungeon.models.creature.player.heroes;

import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.spell.SpecialPower;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.models.creature.SpellCastable;
import com.duels.dungeon.models.spell.spells.LightningBold;
import com.duels.dungeon.utils.Printer;

/**
 * Represents an mage.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class Mage extends Player implements SpellCastable {

    private SpecialPower specialPower;
    private String name;

    /**
     * Creates an mage with the specified name, health, damage and defense.
     * @param name The mage's new name. Type String.
     * Parameters name, health, damage and defense for super class Player.
     * Define mage's special power. Type SpecialPower class.
     */
    public Mage(String name) {
        super(Constants.MAGE, Constants.MAGE_HEALTH, Constants.MAGE_DAMAGE, Constants.MAGE_DEFENSE);
        this.specialPower = new LightningBold();
        this.name = name;
    }

    /**
     * Retrieve current mage's name.
     * @return mage's name. Type String.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the mage's damage dealt.
     * Use params current mage's name (type String),
     * current mage's damage (type int),
     * damage type physical.
     */
    @Override
    public void attack() {
        this.dealDamage(this.getName(), this.getDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    /**
     * Sets the mage's damage taken.
     * @param monsterDamage incoming opponent's damage. Type int.
     * @param monsterDamageType incoming opponent's damage type. Type String.
     * Use params current mage's name (type String)
     */
    @Override
    public void defense(int monsterDamage, String monsterDamageType) {
        this.takeDamage(this.getName(), monsterDamage, monsterDamageType);
    }

    /**
     * Restoring mage's life. Set current mage's health to maximum.
     */
    @Override
    public void replenishLife() {
        this.setHealth(Constants.MAGE_HEALTH);
    }

    /**
     * Retrieve current mage's special power.
     * @return mage's spell power. Type SpellPower class.
     */
    @Override
    public SpecialPower getSpecialPower() {
        return this.specialPower;
    }

    /**
     * Retrieve current mage's special power cast chance.
     * @return mage's spell power cast chance. Type int.
     */
    @Override
    public int getSpecialPowerCastChance() {
        return Constants.MAGE_CAST_SPECIAL_CHANCE;
    }

    /**
     * Set current mage's damage dealt and prints result.
     * Use params current mage's name (type String),
     * current mage's special power damage (type int),
     * current mage's special power type (type String).
     * Print result.
     * Use params current mage's name (type String),
     * current mage's special power name (type String).
     */
    @Override
    public void castSpecial() {
        Printer.castSpecial(this.getName(), this.getSpecialPower().getName());
        this.dealDamage(this.getName(), this.getSpecialPower().getDamage(), this.getSpecialPower().getType());
    }

}
