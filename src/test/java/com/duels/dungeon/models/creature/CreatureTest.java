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

@RunWith(JUnitParamsRunner.class)
public class CreatureTest {

    private Creature creature;
    private Printer printer;

    @Before
    @Test
    public void setUp() throws Exception {
        this.creature = new Creature("Name", 20, 20, 5);
        this.printer = mock(Printer.class);
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
        assertEquals(this.creature.getDefense(), 5);
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
    @Parameters({"Name, 20, physical"})
    public void takeDamage(String name, int damage, String damageType) throws Exception {
        int damageReduced;
        damageReduced = (damage - this.creature.getDefense());
        this.creature.setHealth(this.creature.getHealth() - damageReduced);

        assertEquals(damageType, Constants.DAMAGE_TYPE_PHYSICAL);
        assertEquals(damageReduced, 15);
        assertNotEquals(damageReduced, 20);
        assertEquals(this.creature.getHealth(), 5);
        assertNotEquals(this.creature.getHealth(), 20);
    }

    @Test
    @Parameters({"Name, 30, physical"})
    public void dealDamage(String name, int damage, String damageType) throws Exception {
        this.creature.setDamageDealt(damage);
        this.creature.setDamageDealtType(damageType);
        assertEquals(this.creature.getDamageDealt(), damage);
        assertEquals(this.creature.getDamageDealtType(), Constants.DAMAGE_TYPE_PHYSICAL);
    }
}