package com.duels.dungeon.models.spell.spells;

import com.duels.dungeon.models.spell.SpecialPower;
import com.duels.dungeon.utils.Constants;

/**
 * Represents an spider venom.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class SpiderVenom extends SpecialPower {

    private int damage;

    /**
     * Creates an spider venom with parameter damage.
     * @param damage Set damage of spider venom. Type int.
     * Use parameters spell power name (type String),
     * damage type (type String),
     */
    public SpiderVenom(int damage) {
        super(Constants.SPIDER_VENOM, Constants.DAMAGE_TYPE_MAGIC);
        this.damage = damage;
    }

    /**
     * Retrieve spider venom's damage.
     * @return spider venom's damage. Type int.
     */
    @Override
    public int getDamage() {
        return damage;
    }

}
