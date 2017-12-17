package main.java.com.duels.dungeon.models.monsters;

import com.duels.dungeon.interfaces.IBonusDamager;
import com.duels.dungeon.interfaces.ISpellCaster;
import com.duels.dungeon.models.base.Monster;
import com.duels.dungeon.models.base.SpecialPower;
import com.duels.dungeon.models.spells.Frenzy;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.utils.Printer;

public class Minotaur extends Monster implements IBonusDamager, ISpellCaster {

    private SpecialPower specialPower;

    public Minotaur() {
        super (Constants.MINOTAUR, Constants.MINOTAUR_HEALTH, Constants.MINOTAUR_DAMAGE, Constants.MINOTAUR_DEFENSE);
        this.specialPower = new Frenzy();
    }

    @Override
    public void attack() {
        this.dealDamage(this.getName(), this.getDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    @Override
    public void defense(int playerDamage, String playerDamageType) {
        this.takeDamage(this.getName(), playerDamage, playerDamageType);
    }

    @Override
    public void empowerAttack(int chance) {
        if (chance <= Constants.MINOTAUR_DAMAGE_BONUS_CHANCE) {
            this.setDamage(this.getDamage() + Constants.MINOTAUR_DAMAGE_BONUS_POINT);
        }
        if (chance <= (Constants.MINOTAUR_DAMAGE_BONUS_CHANCE * 2)) {
            this.setDamage(this.getDamage() + Constants.MINOTAUR_DAMAGE_BONUS_POINT);
        }
        else {
            this.resetDamage();
        }
        this.attack();
    }

    @Override
    public void resetDamage() {
        this.setDamage(Constants.MINOTAUR_DAMAGE);
    }

    @Override
    public SpecialPower getSpecialPower() {
        return this.specialPower;
    }

    @Override
    public int getSpecialPowerCastChance() {
        return Constants.MINOTAUR_CAST_SPECIAL_CHANCE;
    }

    @Override
    public void castSpecial() {
        if (getSpecialPower() instanceof Frenzy) {
            Printer.minotaurCastSpecial(this.getName(), this.getSpecialPower().getName());
            this.attack();
        }
    }
}
