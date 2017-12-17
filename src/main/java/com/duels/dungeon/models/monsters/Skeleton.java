package main.java.com.duels.dungeon.models.monsters;

import com.duels.dungeon.interfaces.IBonusDamager;
import com.duels.dungeon.models.base.Monster;
import com.duels.dungeon.utils.Constants;

public class Skeleton extends Monster implements IBonusDamager {

    public Skeleton() {
        super (Constants.SKELETON, Constants.SKELETON_HEALTH, Constants.SKELETON_DAMAGE, Constants.SKELETON_DEFENSE);
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
        if (chance <= Constants.SKELETON_DAMAGE_BONUS_CHANCE) {
            this.setDamage(this.getDamage() + Constants.SKELETON_DAMAGE_BONUS_POINT);
        }
        if (chance <= (Constants.SKELETON_DAMAGE_BONUS_CHANCE * 2)) {
            this.setDamage(this.getDamage() + Constants.SKELETON_DAMAGE_BONUS_POINT);
        }
        else {
            this.resetDamage();
        }
        this.attack();
    }

    @Override
    public void resetDamage() {
        this.setDamage(Constants.SKELETON_DAMAGE);
    }
}