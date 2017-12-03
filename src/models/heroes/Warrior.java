package models.heroes;

import models.base.SpecialPower;
import utils.Constants;
import interfaces.iCastable;
import models.base.DamageBonusCreature;
import models.spells.Cleave;
import utils.Printer;

public class Warrior extends DamageBonusCreature implements iCastable {

    private Cleave specialCast = new Cleave(this.takeDamage() / 2);

    public Warrior() {
        super ("Warrior", Constants.WARRIOR_HEALTH, Constants.WARRIOR_DAMAGE, Constants.WARRIOR_DEFENSE);
    }

    public SpecialPower getSpecialCast() {
        return specialCast;
    }

    public void attack(String playerName) {
        this.addBonusDamage(playerName,
                this.takeDamage(),
                Constants.WARRIOR_DAMAGE_BONUS_POINT,
                Constants.WARRIOR_DAMAGE_BONUS_CHANCE,
                Constants.DAMAGE_TYPE_PHYSICAL);
    }

    public void defense(String playerName, int damage, String damageType) {
        this.takeDamage(playerName, damage, damageType);
    }

    @Override
    public void castSpecial(int chance) {
        this.setDamageDealt(this.getSpecialCast().getDamage());
        this.setDamageDealtType(Constants.DAMAGE_TYPE_MAGIC);
        Printer.warriorCastSpecial(this.getName(), this.getSpecialCast().getName(), this.getSpecialCast().getDamage());
}

}
