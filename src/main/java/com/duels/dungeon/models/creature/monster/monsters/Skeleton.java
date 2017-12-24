package com.duels.dungeon.models.creature.monster.monsters;

import com.duels.dungeon.models.creature.BonusDamagеable;
import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.utils.Constants;

/**
 * Represents an skeleton.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class Skeleton extends Monster implements BonusDamagеable {

    /** Creates an skeleton with the specified name, health, damage and defense.
     * Parameters name, health, damage and defense for super class Player.
     */
    public Skeleton() {
        super (Constants.SKELETON, Constants.SKELETON_HEALTH, Constants.SKELETON_DAMAGE, Constants.SKELETON_DEFENSE);
    }

    /**
     * Sets the skeleton's damage dealt.
     * Use params skeleton's name (type String),
     * skeleton's damage (type int),
     * skeleton damage type physical.
     */
    @Override
    public void attack() {
        this.dealDamage(this.getName(), this.getDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    /**
     * Sets the skeleton's damage taken.
     * @param playerDamage incoming opponent's damage. Type int.
     * @param playerDamageType incoming opponent's damage type. Type String.
     * Use params skeleton's name (type String)
     */
    @Override
    public void defense(int playerDamage, String playerDamageType) {
        this.takeDamage(this.getName(), playerDamage, playerDamageType);
    }

    /**
     * Increase skeletons's damage dealt for current round based on chance and attack.
     * @param chance Generated random number parameter used for calculation of empower success. Type int.
     * Empower action is separated on two phases.
     * First phase check for success according chance param
     *               and add predefined skeletons's bonus point from type int.
     *               Second phase check for success according chance param multiplied by predefined int param
     *               and add another predefined skeletons's bonus point from type int.
     *               If there is no success skeletons's damage is not empowered.
     * Skeleton attack after damage empowering phases.
     */
    @Override
    public void empowerAttack(int chance) {
        if (chance <= Constants.SKELETON_DAMAGE_BONUS_CHANCE) {
            this.setDamage(this.getDamage() + Constants.SKELETON_DAMAGE_BONUS_POINT);
        }
        if (chance <= (Constants.SKELETON_DAMAGE_BONUS_CHANCE *
                Constants.SKELETON_EMPOWER_ATTACK_CHANCE_MULTIPLY_VALUE)) {
            this.setDamage(this.getDamage() + Constants.SKELETON_DAMAGE_BONUS_POINT);
        }
        else {
            this.resetDamage();
        }
        this.attack();
    }

    /** Reset skeleton's damage.
     *  Set skeleton's damage to base damage of the class.
     */
    @Override
    public void resetDamage() {
        this.setDamage(Constants.SKELETON_DAMAGE);
    }
}