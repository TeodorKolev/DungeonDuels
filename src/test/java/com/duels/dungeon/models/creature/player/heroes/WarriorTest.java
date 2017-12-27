package com.duels.dungeon.models.creature.player.heroes;

import com.duels.dungeon.models.creature.Creature;
import com.duels.dungeon.models.spell.spells.Cleave;
import com.duels.dungeon.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class WarriorTest {

    private Warrior warrior;
    private Creature creature;

    @Before
    public void setUp() throws Exception {
        this.warrior = new Warrior("warrior");
        this.creature = Mockito.spy(new Creature(
                Constants.WARRIOR, Constants.WARRIOR_HEALTH, Constants.WARRIOR_DAMAGE, Constants.WARRIOR_DEFENSE));
        assertNotNull(warrior);
        assertNotNull(creature);
    }

    @Test
    public void getName() {
        assertEquals("warrior", warrior.getName());
    }

    @Test
    public void attack() {
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        warrior.attack();
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void defense() {
        Mockito.doNothing().when(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        warrior.defense(15, Constants.DAMAGE_TYPE_PHYSICAL);
        creature.takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void replenishLife() {
        warrior.replenishLife();
        assertEquals(Constants.WARRIOR_HEALTH, warrior.getHealth());
    }

    @Test
    public void getSpecialPower() {
        assertEquals(Cleave.class, warrior.getSpecialPower().getClass());
    }

    @Test
    public void getSpecialPowerCastChance() {
        assertEquals(Constants.WARRIOR_CAST_SPECIAL_CHANCE, warrior.getSpecialPowerCastChance());
    }

    @Test
    public void castSpecial() {
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        warrior.castSpecial();
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void empowerAttackOnce() {
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        warrior.empowerAttack(55);
        creature.setDamage(warrior.getDamage() + Constants.WARRIOR_DAMAGE_BONUS_POINT);
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        assertEquals(12, warrior.getDamage());
    }

    @Test
    public void empowerAttackTwice() {
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        warrior.empowerAttack(15);
        creature.setDamage(warrior.getDamage() + Constants.WARRIOR_DAMAGE_BONUS_POINT);
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        assertEquals(13, warrior.getDamage());
    }

    @Test
    public void empowerAttackNone() {
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        warrior.empowerAttack(67);
        creature.setDamage(warrior.getDamage() + Constants.WARRIOR_DAMAGE_BONUS_POINT);
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        assertEquals(11, warrior.getDamage());
    }

    @Test
    public void resetDamage() {
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        warrior.resetDamage();
        creature.setDamage(Constants.WARRIOR_DAMAGE);
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        assertEquals(Constants.WARRIOR_DAMAGE, warrior.getDamage());
    }
}