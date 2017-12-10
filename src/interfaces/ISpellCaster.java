package interfaces;

import models.base.SpecialPower;

public interface iCastable {

    SpecialPower getSpecialPower();

    int getSpecialPowerCastChance();

    void castSpecial();

}
