package com.duels.dungeon.models.creature.monster.monsters;

import com.duels.dungeon.models.creature.BonusDamagеable;
import com.duels.dungeon.models.creature.SpellCastable;
import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.spell.SpecialPower;
import com.duels.dungeon.models.spell.spells.Frenzy;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.utils.Printer;

public class Minotaur extends Monster implements BonusDamagеable, SpellCastable {

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
