package com.duels.dungeon.models.monsters;

import com.duels.dungeon.models.base.SpellCastable;
import com.duels.dungeon.models.base.Monster;
import com.duels.dungeon.models.base.SpecialPower;
import com.duels.dungeon.models.spells.SpiderVenom;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.utils.Printer;

public class GiantSpider extends Monster implements SpellCastable {

    private SpecialPower specialPower;

    public GiantSpider() {
        super (Constants.GIANT_SPIDER, Constants.GIANT_SPIDER_HEALTH, Constants.GIANT_SPIDER_DAMAGE,
                Constants.GIANT_SPIDER_DEFENSE);
        this.specialPower = new SpiderVenom(Constants.SPIDER_VENOM_DAMAGE + this.getHealth() / 10);
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
    public SpecialPower getSpecialPower() {
        return this.specialPower;
    }

    @Override
    public int getSpecialPowerCastChance() {
        return Constants.GIANT_SPIDER_CAST_SPECIAL_CHANCE;
    }

    @Override
    public void castSpecial() {
        this.setDamageDealt(this.getSpecialPower().getDamage());
        this.setDamageDealtType(this.getSpecialPower().getType());
        Printer.giantSpiderCastSpecial(this.getName(), this.getSpecialPower().getName(),
                this.getSpecialPower().getDamage());
    }
}