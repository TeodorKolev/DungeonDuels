package com.duels.dungeon.models.creature.monster.monsters;

import com.duels.dungeon.models.creature.SpellCastable;
import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.spell.SpecialPower;
import com.duels.dungeon.models.spell.spells.SpiderVenom;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.utils.Printer;
/**
 * Represents an gian spider.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class GiantSpider extends Monster implements SpellCastable {

    private SpecialPower specialPower;

    /**
     * Creates an gian spider with the specified name, health, damage and defense.
     * Parameters name, health, damage and defense for super class Monster.
     * Define gian spider's special power. SpiderVenom class
     * with damage predefined int parameter plus one tenth of spider health.
     */
    public GiantSpider() {
        super (Constants.GIANT_SPIDER, Constants.GIANT_SPIDER_HEALTH, Constants.GIANT_SPIDER_DAMAGE,
                Constants.GIANT_SPIDER_DEFENSE);
        this.specialPower = new SpiderVenom(Constants.SPIDER_VENOM_DAMAGE +
                this.getHealth() / Constants.GIANT_SPIDER_CAST_SPECIAL_DIVISION_VALUE);
    }

    /**
     * Sets the giant spider's damage dealt.
     * Use giant spider skeleton's name (type String),
     * giant spider's damage (type int),
     * giant spider damage type physical.
     */
    @Override
    public void attack() {
        this.dealDamage(this.getName(), this.getDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    /**
     * Sets the giant spider's damage taken.
     * @param playerDamage incoming opponent's damage. Type int.
     * @param playerDamageType incoming opponent's damage type. Type String.
     * Use params giant spider's name (type String)
     */
    @Override
    public void defense(int playerDamage, String playerDamageType) {
        this.takeDamage(this.getName(), playerDamage, playerDamageType);
    }

    /**
     * Retrieve giant spider's special power.
     * @return giant spider's spell power. Type SpellPower class.
     */
    @Override
    public SpecialPower getSpecialPower() {
        return this.specialPower;
    }

    /**
     * Retrieve giant spider's special power cast chance.
     * @return giant spider's spell power cast chance. Type int.
     */
    @Override
    public int getSpecialPowerCastChance() {
        return Constants.GIANT_SPIDER_CAST_SPECIAL_CHANCE;
    }

    /**
     * Set giant spider's damage dealt and prints result.
     * Use params current giant spider's name (type String),
     * giant spider's special power damage (type int),
     * giant spider's special power type (type String).
     * Print result.
     * Use params giant spider's name (type String),
     * giant spider's special power name (type String).
     */
    @Override
    public void castSpecial() {
        this.setDamageDealt(this.getSpecialPower().getDamage());
        this.setDamageDealtType(this.getSpecialPower().getType());
        Printer.giantSpiderCastSpecial(this.getName(), this.getSpecialPower().getName(),
                this.getSpecialPower().getDamage());
    }
}