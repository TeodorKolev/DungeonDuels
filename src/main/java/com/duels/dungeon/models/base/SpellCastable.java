package com.duels.dungeon.interfaces;

import com.duels.dungeon.models.base.SpecialPower;

public interface ISpellCaster {

    SpecialPower getSpecialPower();

    int getSpecialPowerCastChance();

    void castSpecial();

}
