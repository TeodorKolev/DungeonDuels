package com.duels.dungeon.models.creature;

import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.utils.Printer;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreatureTest {

    private Creature creature;

    @Before
    @Test
    public void setUp() throws Exception {
        this.creature = new Creature("Name", 20, 20, 5);
        assertNotNull(creature);
    }

    @Test
    public void getDamageDealtType() throws Exception {
        creature.setDamageDealtType("magical");
        assertEquals(creature.getDamageDealtType(), "magical");
        assertNotEquals(creature.getDamageDealtType(), "wrong");
        assertNotNull(creature.getDamageDealtType());
    }

    @Test
    public void setDamageDealtType() throws Exception {
        creature.setDamageDealtType("magical");
        assertEquals(creature.getDamageDealtType(), "magical");
        assertNotEquals(creature.getDamageDealtType(), "wrong");
        assertNotNull(creature.getDamageDealtType());
    }

    @Test
    public void getDamageDealt() throws Exception {
        creature.setDamageDealt(20);
        assertEquals(creature.getDamageDealt(), 20);
        assertNotEquals(creature.getDamageDealt(), "wrong");
    }

    @Test
    public void setDamageDealt() throws Exception {
        creature.setDamageDealt(20);
        assertEquals(creature.getDamageDealt(), 20);
        assertNotEquals(creature.getDamageDealt(), "wrong");
    }

    @Test
    public void getDefense() throws Exception {
        assertEquals(creature.getDefense(), 5);
        assertNotEquals(creature.getDefense(), "wrong");
    }

    @Test
    public void getHealth() throws Exception {
        assertEquals(creature.getHealth(), 20);
        assertNotEquals(creature.getHealth(), "wrong");
    }

    @Test
    public void setHealth() throws Exception {
        creature.setHealth(21);
        assertEquals(creature.getHealth(), 21);
        assertNotEquals(creature.getHealth(), 20);
    }

    @Test
    public void getDamage() throws Exception {
        assertEquals(creature.getDamage(), 20);
        assertNotEquals(creature.getDamage(), 21);
    }

    @Test
    public void setDamage() throws Exception {
        creature.setDamage(21);
        assertEquals(creature.getDamage(), 21);
        assertNotEquals(creature.getDamage(), 20);
    }

    @Test
    public void isAlive() throws Exception {
        assertTrue(creature.isAlive());
        creature.setHealth(0);
        assertFalse(creature.isAlive());
    }

    @Test
    public void takeDamagePhysical() throws Exception {
        creature.takeDamage("name", 10, Constants.DAMAGE_TYPE_PHYSICAL);
        assertEquals(creature.getHealth(), 15);
    }

    @Test
    public void takeDamageMagical() throws Exception {
        creature.takeDamage("name", 10, Constants.DAMAGE_TYPE_MAGIC);
        assertEquals(creature.getHealth(), 10);
    }

    @Test
    public void dealDamage() throws Exception {
        creature.dealDamage("Name",30, Constants.DAMAGE_TYPE_PHYSICAL);
        assertEquals(creature.getDamageDealt(), 30);
        assertEquals(creature.getDamageDealtType(), Constants.DAMAGE_TYPE_PHYSICAL);
    }
}