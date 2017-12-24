package com.duels.dungeon.models.creature.player.heroes;

import com.duels.dungeon.models.creature.SpellCastable;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.spell.SpecialPower;
import com.duels.dungeon.models.spell.spells.SoulTrade;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.utils.Printer;

/**
 * Represents an warlock.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class Warlock extends Player implements SpellCastable {

    private SpecialPower specialPower;
    private String name;

    /**
     * Creates an warlock with the specified name, health, damage and defense.
     * @param name The warlock's new name. Type String.
     * Parameters name, health, damage and defense for super class Player.
     * Define warlock's special power. Type SpecialPower class.
     */
    public Warlock(String name) {
        super(Constants.WARLOCK, Constants.WARLOCK_HEALTH, Constants.WARLOCK_DAMAGE, Constants.WARLOCK_DEFENSE);
        this.specialPower = new SoulTrade();
        this.name = name;
    }

    /**
     * Retrieve current warlock's name.
     * @return warlock's name. Type String.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the warlock's damage dealt.
     * Use params current warlock's name (type String),
     * current warlock's damage (type int),
     * damage type physical.
     */
    @Override
    public void attack() {
        this.dealDamage(this.getName(), this.getDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    /**
     * Sets the warlock's damage taken.
     * @param monsterDamage incoming opponent's damage. Type int.
     * @param monsterDamageType incoming opponent's damage type. Type String.
     * Use params current warlock's name (type String)
     */
    @Override
    public void defense(int monsterDamage, String monsterDamageType) {
        this.takeDamage(this.getName(), monsterDamage, monsterDamageType);
    }

    /**
     * Restoring warlock's life. Set current warlock's health to maximum.
     */
    @Override
    public void replenishLife() {
        this.setHealth(Constants.WARLOCK_HEALTH);
    }

    /**
     * Retrieve current warlock's special power.
     * @return warlock's spell power. Type SpellPower class.
     */
    @Override
    public SpecialPower getSpecialPower() {
        return this.specialPower;
    }

    /**
     * Retrieve current warlock's special power cast chance.
     * @return warlock's spell power cast chance. Type int.
     */
    @Override
    public int getSpecialPowerCastChance() {
        return Constants.WARLOCK_CAST_SPECIAL_CHANCE;
    }

    /**
     * Set current warlock's damage dealt and prints result.
     * Use params current warlock's name (type String),
     * current warlock's special power damage (type int),
     * current warlock's special power type (type String).
     * Print result.
     * Use params current warlock's name (type String),
     * current warlock's special power name (type String).
     */
    @Override
    public void castSpecial() {
        Printer.castSpecial(this.getName(), this.getSpecialPower().getName());
        this.dealDamage(this.getName(), this.getSpecialPower().getDamage(), this.getSpecialPower().getType());
    }

    /**
     * Warlock takes penalty on every cast. On successful cast deals damage
     * cast his special power.
     * Print penalty use params current warlock's name (type String),
     * current warlock's special power name (type String),
     * current warlock's special power penalty (type int).
     * @param chanceToCast Generated random number parameter used for calculation of cast success. Type int.
     */
    public void specialPenalty(int chanceToCast) {
        Printer.soulTradePenalty(this.getName(), this.getSpecialPower().getName(), Constants.WARLOCK_CAST_SPECIAL_PENALTY);
        this.takeDamage(this.getName(), Constants.WARLOCK_CAST_SPECIAL_PENALTY, this.getSpecialPower().getType());
        if (chanceToCast <= Constants.WARLOCK_CAST_SPECIAL_CHANCE) {
            this.castSpecial();
        }
    }

}
