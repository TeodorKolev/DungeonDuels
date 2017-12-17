package com.duels.dungeon.models.base;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreatureTest {

    private Creature creature;

    @Before
    @Test
    public void setUp() throws Exception {
        creature = new Creature("Name", 20, 20, 20);
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
        assertNotNull(this.creature.getDamageDealt());
    }

    @Test
    public void setDamageDealt() throws Exception {
        this.creature.setDamageDealt(20);
        assertEquals(this.creature.getDamageDealt(), 20);
        assertNotEquals(this.creature.getDamageDealt(), "wrong");
        assertNotNull(this.creature.getDamageDealt());
    }

    @Test
    public void getDefense() throws Exception {
        assertEquals(this.creature.getDefense(), 20);
        assertNotEquals(this.creature.getDefense(), "wrong");
        assertNotNull(this.creature.getDefense());
    }

    @Test
    public void getHealth() throws Exception {
        assertEquals(this.creature.getHealth(), 20);
        assertNotEquals(this.creature.getHealth(), "wrong");
        assertNotNull(this.creature.getHealth());
    }

    @Test
    public void setHealth() throws Exception {
        this.creature.setHealth(21);
        assertEquals(this.creature.getHealth(), 21);
        assertNotEquals(this.creature.getHealth(), 20);
        assertNotNull(this.creature.getHealth());
    }

    @Test
    public void getDamage() throws Exception {
        assertEquals(this.creature.getDamage(), 20);
        assertNotEquals(this.creature.getDamage(), 21);
        assertNotNull(this.creature.getDamage());
    }

    @Test
    public void setDamage() throws Exception {
        this.creature.setDamage(21);
        assertEquals(this.creature.getDamage(), 21);
        assertNotEquals(this.creature.getDamage(), 20);
        assertNotNull(this.creature.getDamage());
    }

    @Test
    public void isAlive() throws Exception {
        assertTrue(this.creature.isAlive());
        this.creature.setHealth(0);
        assertFalse(this.creature.isAlive());
    }

    @Test
    public void takeDamage() throws Exception {
    }

    @Test
    public void dealDamage() throws Exception {
    }

}