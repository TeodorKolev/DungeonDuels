package com.duels.dungeon.models.creature.player.heroes;

import com.duels.dungeon.models.creature.Creature;
import com.duels.dungeon.models.spell.spells.SoulTrade;
import com.duels.dungeon.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class WarlockTest {

    private Warlock warlock;
    private Creature creature;

    @Before
    public void setUp() throws Exception {
        this.warlock = new Warlock("warlock");
        this.creature = Mockito.spy(
                new Creature(Constants.WARLOCK, Constants.WARLOCK_HEALTH,
                        Constants.WARLOCK_DAMAGE, Constants.WARLOCK_DEFENSE));
        assertNotNull(warlock);
        assertNotNull(creature);
    }

    @Test
    public void getName() {
        assertEquals("warlock", warlock.getName());
    }

    @Test
    public void attack() {
        Mockito.doNothing().when(creature).dealDamage("warlock", 9, Constants.DAMAGE_TYPE_PHYSICAL);
        creature.dealDamage("warlock", 9, Constants.DAMAGE_TYPE_PHYSICAL);
        warlock.attack();
        Mockito.verify(creature).dealDamage("warlock", 9, Constants.DAMAGE_TYPE_PHYSICAL);
    }

    @Test
    public void defense() {
        Mockito.doNothing().when(creature).takeDamage("monster", 15, Constants.DAMAGE_TYPE_PHYSICAL);
        warlock.defense(15, Constants.DAMAGE_TYPE_PHYSICAL);
        creature.takeDamage("monster", 15, Constants.DAMAGE_TYPE_PHYSICAL);
        Mockito.verify(creature).takeDamage("monster", 15, Constants.DAMAGE_TYPE_PHYSICAL);
    }

    @Test
    public void replenishLife() {
        warlock.replenishLife();
        assertEquals(Constants.WARLOCK_HEALTH, warlock.getHealth());
    }

    @Test
    public void getSpecialPower() {
        assertEquals(SoulTrade.class, warlock.getSpecialPower().getClass());
    }

    @Test
    public void getSpecialPowerCastChance() {
        assertEquals(Constants.WARLOCK_CAST_SPECIAL_CHANCE, warlock.getSpecialPowerCastChance());
    }

    @Test
    public void castSpecial() {
        Mockito.doNothing().when(creature).dealDamage(
                "warlock", warlock.getSpecialPower().getDamage(), Constants.DAMAGE_TYPE_MAGIC);
        creature.dealDamage("warlock", warlock.getSpecialPower().getDamage(), Constants.DAMAGE_TYPE_MAGIC);
        warlock.castSpecial();
        Mockito.verify(creature).dealDamage("warlock",
                warlock.getSpecialPower().getDamage(), Constants.DAMAGE_TYPE_MAGIC);
    }

    @Test
    public void specialPenalty() {
        Mockito.doNothing().when(creature).takeDamage("warlock",
                Constants.WARLOCK_CAST_SPECIAL_PENALTY, Constants.DAMAGE_TYPE_PHYSICAL);
        Mockito.doNothing().when(creature).dealDamage("warlock", warlock.getSpecialPower().getDamage(),
                Constants.DAMAGE_TYPE_MAGIC);
        warlock.specialPenalty(10);
        creature.takeDamage("warlock", Constants.WARLOCK_CAST_SPECIAL_PENALTY, Constants.DAMAGE_TYPE_PHYSICAL);
        creature.dealDamage("warlock", warlock.getSpecialPower().getDamage(), Constants.DAMAGE_TYPE_MAGIC);
        Mockito.verify(creature).takeDamage("warlock",
                Constants.WARLOCK_CAST_SPECIAL_PENALTY, Constants.DAMAGE_TYPE_PHYSICAL);
        Mockito.verify(creature).dealDamage("warlock",
                warlock.getSpecialPower().getDamage(), Constants.DAMAGE_TYPE_MAGIC);
    }

}