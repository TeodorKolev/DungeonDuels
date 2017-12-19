package com.duels.dungeon.models.base;

public interface SpellCastable {

    SpecialPower getSpecialPower();

    int getSpecialPowerCastChance();

    void castSpecial();

}
