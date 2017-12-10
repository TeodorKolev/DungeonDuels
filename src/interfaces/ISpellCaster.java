package interfaces;

import models.base.SpecialPower;

public interface ISpellCaster {

    SpecialPower getSpecialPower();

    int getSpecialPowerCastChance();

    void castSpecial();

}
