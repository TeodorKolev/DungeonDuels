package com.duels.dungeon.models.creature.player.heroes;

import com.duels.dungeon.models.creature.SpellCastable;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.spell.SpecialPower;
import com.duels.dungeon.models.spell.spells.SoulTrade;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.utils.Printer;

public class Warlock extends Player implements SpellCastable {

    private SpecialPower specialPower;
    private String name;

    public Warlock(String name) {
        super(Constants.WARLOCK, Constants.WARLOCK_HEALTH, Constants.WARLOCK_DAMAGE, Constants.WARLOCK_DEFENSE);
        this.specialPower = new SoulTrade();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void attack() {
        this.dealDamage(this.getName(), this.getDamage(), Constants.DAMAGE_TYPE_PHYSICAL);
    }

    @Override
    public void defense(int monsterDamage, String monsterDamageType) {
        this.takeDamage(this.getName(), monsterDamage, monsterDamageType);
    }

    @Override
    public void replenishLife() {
        this.setHealth(Constants.WARLOCK_HEALTH);
    }

    @Override
    public SpecialPower getSpecialPower() {
        return this.specialPower;
    }

    @Override
    public int getSpecialPowerCastChance() {
        return Constants.WARLOCK_CAST_SPECIAL_CHANCE;
    }

    @Override
    public void castSpecial() {
        Printer.castSpecial(this.getName(), this.getSpecialPower().getName());
        this.dealDamage(this.getName(), this.getSpecialPower().getDamage(), this.getSpecialPower().getType());
    }

    public void specialPenalty(int chanceToCast) {
        Printer.soulTradePenalty(this.getName(), this.getSpecialPower().getName(), Constants.WARLOCK_CAST_SPECIAL_PENALTY);
        this.takeDamage(this.getName(), Constants.WARLOCK_CAST_SPECIAL_PENALTY, this.getSpecialPower().getType());
        if (chanceToCast <= Constants.WARLOCK_CAST_SPECIAL_CHANCE) {
            this.castSpecial();
        }
    }

}
