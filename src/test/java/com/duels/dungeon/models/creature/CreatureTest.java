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
        this.creature.setDamageDealtType("magical");
        assertEquals(this.creature.getDamageDealtType(), "magical");
        assertNotEquals(this.creature.getDamageDealtType(), "wrong");
        assertNotNull(this.creature.getDamageDealtType());
    }

    @Test
    public void setDamageDealtType() throws Exception {
        this.creature.setDamageDealtType("magical");
        assertEquals(this.creature.getDamageDealtType(), "magical");
        assertNotEquals(this.creature.getDamageDealtType(), "wrong");
        assertNotNull(this.creature.getDamageDealtType());
    }

    @Test
    public void getDamageDealt() throws Exception {
        this.creature.setDamageDealt(20);
        assertEquals(this.creature.getDamageDealt(), 20);
        assertNotEquals(this.creature.getDamageDealt(), "wrong");
    }

    @Test
    public void setDamageDealt() throws Exception {
        this.creature.setDamageDealt(20);
        assertEquals(this.creature.getDamageDealt(), 20);
        assertNotEquals(this.creature.getDamageDealt(), "wrong");
    }

    @Test
    public void getDefense() throws Exception {
        assertEquals(this.creature.getDefense(), 5);
        assertNotEquals(this.creature.getDefense(), "wrong");
    }

    @Test
    public void getHealth() throws Exception {
        assertEquals(this.creature.getHealth(), 20);
        assertNotEquals(this.creature.getHealth(), "wrong");
    }

    @Test
    public void setHealth() throws Exception {
        this.creature.setHealth(21);
        assertEquals(this.creature.getHealth(), 21);
        assertNotEquals(this.creature.getHealth(), 20);
    }

    @Test
    public void getDamage() throws Exception {
        assertEquals(this.creature.getDamage(), 20);
        assertNotEquals(this.creature.getDamage(), 21);
    }

    @Test
    public void setDamage() throws Exception {
        this.creature.setDamage(21);
        assertEquals(this.creature.getDamage(), 21);
        assertNotEquals(this.creature.getDamage(), 20);
    }

    @Test
    public void isAlive() throws Exception {
        assertTrue(this.creature.isAlive());
        this.creature.setHealth(0);
        assertFalse(this.creature.isAlive());
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
        this.creature.dealDamage("Name",30, Constants.DAMAGE_TYPE_PHYSICAL);
        assertEquals(this.creature.getDamageDealt(), 30);
        assertEquals(this.creature.getDamageDealtType(), Constants.DAMAGE_TYPE_PHYSICAL);
    }
}