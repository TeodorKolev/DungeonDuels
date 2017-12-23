package com.duels.dungeon.models.creature;

import com.duels.dungeon.models.spell.SpecialPower;

public interface SpellCastable {

    SpecialPower getSpecialPower();

    int getSpecialPowerCastChance();

    void castSpecial();

}
