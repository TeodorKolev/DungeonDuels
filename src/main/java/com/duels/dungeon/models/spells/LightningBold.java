package main.java.com.duels.dungeon.models.spells;

import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.models.base.SpecialPower;

public class LightningBold extends SpecialPower {

    public LightningBold() {
        super(Constants.LIGHTNING_BOLD, Constants.DAMAGE_TYPE_MAGIC, Constants.LIGHTNING_BOLD_DAMAGE);
    }
}
