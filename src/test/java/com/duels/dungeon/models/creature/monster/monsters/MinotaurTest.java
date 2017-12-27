package com.duels.dungeon.models.creature.monster.monsters;

import com.duels.dungeon.models.creature.Creature;
import com.duels.dungeon.models.spell.spells.Frenzy;
import com.duels.dungeon.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class MinotaurTest {

    private Minotaur minotaur;
    private Creature creature;

    @Before
    public void setUp() throws Exception {
        this.minotaur = new Minotaur();
        this.creature = Mockito.spy(new Creature(
                Constants.MINOTAUR, Constants.MAGE_HEALTH, Constants.MINOTAUR_DAMAGE, Constants.MINOTAUR_DEFENSE));
        assertNotNull(minotaur);
        assertNotNull(creature);
    }

    @Test
    public void attack() {
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        minotaur.attack();
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void defense() {
        Mockito.doNothing().when(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        minotaur.defense(15, Constants.DAMAGE_TYPE_PHYSICAL);
        creature.takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void empowerAttackOnce() {
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        minotaur.empowerAttack(35);
        creature.setDamage(minotaur.getDamage() + Constants.MINOTAUR_DAMAGE_BONUS_POINT);
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        assertEquals(12, minotaur.getDamage());
    }

    @Test
    public void empowerAttackTwice() {
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        minotaur.empowerAttack(15);
        creature.setDamage(minotaur.getDamage() + Constants.MINOTAUR_DAMAGE_BONUS_POINT);
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        assertEquals(13, minotaur.getDamage());
    }

    @Test
    public void empowerAttackNone() {
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        minotaur.empowerAttack(67);
        creature.setDamage(minotaur.getDamage() + Constants.MINOTAUR_DAMAGE_BONUS_POINT);
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        assertEquals(11, minotaur.getDamage());
    }

    @Test
    public void resetDamage() {
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        minotaur.resetDamage();
        creature.setDamage(Constants.MINOTAUR_DAMAGE);
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        assertEquals(Constants.MINOTAUR_DAMAGE, minotaur.getDamage());
    }

    @Test
    public void getSpecialPower() {
        assertEquals(Frenzy.class, minotaur.getSpecialPower().getClass());
    }

    @Test
    public void getSpecialPowerCastChance() {
        assertEquals(Constants.MINOTAUR_CAST_SPECIAL_CHANCE, minotaur.getSpecialPowerCastChance());
    }

    @Test
    public void castSpecial() {
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        minotaur.castSpecial();
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }
}