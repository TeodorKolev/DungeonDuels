package com.duels.dungeon.models.creature.monster.monsters;

import com.duels.dungeon.models.creature.Creature;
import com.duels.dungeon.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class SkeletonTest {

    private Skeleton skeleton;
    private Creature creature;

    @Before
    public void setUp() throws Exception {
        this.skeleton = new Skeleton();
        this.creature = Mockito.spy(new Creature(
                Constants.SKELETON, Constants.SKELETON_HEALTH, Constants.SKELETON_DAMAGE, Constants.SKELETON_DEFENSE));
        assertNotNull(skeleton);
        assertNotNull(creature);
    }

    @Test
    public void attack() {
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        skeleton.attack();
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void defense() {
        Mockito.doNothing().when(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        skeleton.defense(15, Constants.DAMAGE_TYPE_PHYSICAL);
        creature.takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void empowerAttackOnce() {
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        skeleton.empowerAttack(55);
        creature.setDamage(skeleton.getDamage() + Constants.SKELETON_DAMAGE_BONUS_POINT);
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        assertEquals(8, skeleton.getDamage());
    }

    @Test
    public void empowerAttackTwice() {
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        skeleton.empowerAttack(15);
        creature.setDamage(skeleton.getDamage() + Constants.SKELETON_DAMAGE_BONUS_POINT);
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        assertEquals(9, skeleton.getDamage());
    }

    @Test
    public void empowerAttackNone() {
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        skeleton.empowerAttack(67);
        creature.setDamage(skeleton.getDamage() + Constants.SKELETON_DAMAGE_BONUS_POINT);
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        assertEquals(7, skeleton.getDamage());
    }

    @Test
    public void resetDamage() {
        Mockito.doNothing().when(creature).setDamage(Mockito.anyInt());
        skeleton.resetDamage();
        creature.setDamage(Constants.SKELETON_DAMAGE);
        Mockito.verify(creature).setDamage(Mockito.anyInt());
        assertEquals(Constants.SKELETON_DAMAGE, skeleton.getDamage());
    }
}