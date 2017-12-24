package com.duels.dungeon.models.spell.spells;

import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.models.spell.SpecialPower;

/**
 * Represents an cleave.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class Cleave extends SpecialPower {

    private int damage;

    /**
     * Creates an cleave with the specified parameter damage.
     * @param damage The spell power's damage power. Type int.
     *               Use parameters spell power name (type String),
     *               spell power damage (type String).
     */
    public Cleave(int damage) {
        super(Constants.CLEAVE, Constants.DAMAGE_TYPE_MAGIC);
        this.damage = damage;
    }

    /**
     * Retrieve cleave's damage.
     * @return cleave's damage. Type int.
     */
    @Override
    public int getDamage() {
        return damage;
    }

}
