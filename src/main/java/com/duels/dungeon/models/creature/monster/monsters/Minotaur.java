package com.duels.dungeon.models.creature.monster.monsters;

import com.duels.dungeon.models.creature.BonusDamagеable;
import com.duels.dungeon.models.creature.SpellCastable;
import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.spell.SpecialPower;
import com.duels.dungeon.models.spell.spells.Frenzy;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.utils.Printer;

/**
 * Represents an minotaur.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class Minotaur extends Monster implements BonusDamagеable, SpellCastable {

    private SpecialPower specialPower;

    /**
     * Creates an minotaur with the specified name, health, damage and defense.
     * Parameters name, health, damage and defense for super class Monster.
     * Define minotaur's special power. Frenzy class
     */
    public Minotaur() {
        super (Constants.MINOTAUR, Constants.MINOTAUR_HEALTH, Constants.MINOTAUR_DAMAGE, Constants.MINOTAUR_DEFENSE);
        this.specialPower = new Frenzy();
    }

    /**
     * Sets the minotaur's damage dealt.
     * Use params minotaur's name (type String),
     * minotaur's damage (type int),
     * minotaur damage type physical.
     */
    @Override
    public void attack() {
        this.dealDamage(this.getName(), this.getDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    /**
     * Sets the minotaur's damage taken.
     * @param playerDamage incoming opponent's damage. Type int.
     * @param playerDamageType incoming opponent's damage type. Type String.
     * Use params minotaur's name (type String)
     */
    @Override
    public void defense(int playerDamage, String playerDamageType) {
        this.takeDamage(this.getName(), playerDamage, playerDamageType);
    }

    /**
     * Increase minotaur's damage dealt for current round based on chance and attack.
     * @param chance Generated random number parameter used for calculation of empower success. Type int.
     * Empower action is separated on two phases.
     * First phase check for success according chance param
     *               and add predefined minotaur's bonus point from type int.
     *               Second phase check for success according chance param multiplied by predefined int param
     *               and add another predefined minotaur's bonus point from type int.
     *               If there is no success minotaur's damage is not empowered.
     * Minotaur attack after damage empowering phases.
     */
    @Override
    public void empowerAttack(int chance) {
        if (chance <= Constants.MINOTAUR_DAMAGE_BONUS_CHANCE) {
            this.setDamage(this.getDamage() + Constants.MINOTAUR_DAMAGE_BONUS_POINT);
        }
        if (chance <= (Constants.MINOTAUR_DAMAGE_BONUS_CHANCE *
                Constants.MINOTAUR_EMPOWER_ATTACK_CHANCE_MULTIPLY_VALUE)) {
            this.setDamage(this.getDamage() + Constants.MINOTAUR_DAMAGE_BONUS_POINT);
        }
        else {
            this.resetDamage();
        }
        this.attack();
    }

    /**
     * Reset minotaur's damage.
     *  Set minotaur's damage to base damage of the class.
     */
    @Override
    public void resetDamage() {
        this.setDamage(Constants.MINOTAUR_DAMAGE);
    }

    /**
     * Retrieve minotaur's special power.
     * @return minotaur's spell power. Type SpellPower class.
     */
    @Override
    public SpecialPower getSpecialPower() {
        return this.specialPower;
    }

    /**
     * Retrieve giant minotaur's special power cast chance.
     * @return giant minotaur's spell power cast chance. Type int.
     */
    @Override
    public int getSpecialPowerCastChance() {
        return Constants.MINOTAUR_CAST_SPECIAL_CHANCE;
    }

    /**
     * Cast Frenzy which apply extra attack.
     * Use params minotaur's name (type String),
     * minotaur's special power name (type String),
     */
    @Override
    public void castSpecial() {
        if (getSpecialPower() instanceof Frenzy) {
            Printer.minotaurCastSpecial(this.getName(), this.getSpecialPower().getName());
            this.attack();
        }
    }
}
