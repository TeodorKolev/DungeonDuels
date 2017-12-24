package com.duels.dungeon.models.creature.player.heroes;

import com.duels.dungeon.models.creature.BonusDamagеable;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.spell.SpecialPower;
import com.duels.dungeon.models.spell.spells.Cleave;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.models.creature.SpellCastable;
import com.duels.dungeon.utils.Printer;

/**
 * Represents an warrior.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class Warrior extends Player implements SpellCastable, BonusDamagеable {

    private SpecialPower specialPower;
    private String name;

    /** Creates an warrior with the specified name, health, damage and defense.
     * @param name The warrior's new name. Type String.
     * Parameters name, health, damage and defense for super class Player.
     * Define warrior's special power. Cleave class with damage equals to half of current warrior's damage.
     */
    public Warrior(String name) {
        super (Constants.WARRIOR, Constants.WARRIOR_HEALTH, Constants.WARRIOR_DAMAGE, Constants.WARRIOR_DEFENSE);
        this.specialPower = new Cleave(this.getDamage() / Constants.WARRIOR_CLEAVE_DIVIDING);
        this.name = name;
    }

    /**
     * Retrieve current warrior's name.
     * @return warrior's name. Type String.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the warrior's damage dealt.
     * Use params current warrior's name (type String),
     * current warrior's damage (type int),
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

    /** Restoring warrior's life. Set current warrior's health to maximum.
     */
    @Override
    public void replenishLife() {
        this.setHealth(Constants.WARRIOR_HEALTH);
    }

    /**
     * Retrieve current warrior's special power.
     * @return warrior's spell power. Type SpellPower class.
     */
    @Override
    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    /**
     * Retrieve current warrior's special power cast chance.
     * @return warrior's spell power cast chance. Type int.
     */
    @Override
    public int getSpecialPowerCastChance() {
        return Constants.WARRIOR_CAST_SPECIAL_CHANCE;
    }

    /**
     * Set current warrior's damage dealt and prints result.
     * Use params current warrior's name (type String),
     *               current warrior's special power damage (type int),
     *               current warrior's special power type (type String).
     * Print result.
     * Use params current warrior's name (type String)
     *               current warrior's special power name (type String).
     */
    @Override
    public void castSpecial() {
        Printer.castSpecial(this.getName(), this.getSpecialPower().getName());
        this.dealDamage(this.getName(), this.getSpecialPower().getDamage(), this.getSpecialPower().getType());
    }

    /**
     * Increase current warrior's damage dealt for current round based on chance and attack.
     * @param chance Generated random number parameter used for calculation of empower success. Type int.
     * Empower action is separated on two phases.
     * First phase check for success according chance param
     *               and add predefined warrior's bonus point from type int.
     *               Second phase check for success according chance param multiplied by predefined int param
     *               and add another predefined warrior's bonus point from type int.
     *               If there is no success warrior's damage is not empowered.
     * Warrior attack after damage empowering phases.
     */
    @Override
    public void empowerAttack(int chance) {
        if (chance <= Constants.WARRIOR_DAMAGE_BONUS_CHANCE) {
            this.setDamage(this.getDamage() + Constants.WARRIOR_DAMAGE_BONUS_POINT);
        }
        if (chance <= (Constants.WARRIOR_DAMAGE_BONUS_CHANCE *
                Constants.WARRIOR_EMPOWER_ATTACK_CHANCE_MULTIPLY_VALUE)) {
            this.setDamage(this.getDamage() + Constants.WARRIOR_DAMAGE_BONUS_POINT);
        }
        else {
            this.resetDamage();
        }
        this.attack();
    }

    /** Reset warrior's damage.
     *  Set current warrior's damage to base damage of the class.
     */
    @Override
    public void resetDamage() {
        this.setDamage(Constants.WARRIOR_DAMAGE);
    }
}
