package models.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    private Creature creature;

    @BeforeEach
    void setUp() {
        creature = new Creature("Name", 20, 20, 20);
        assertNotNull(creature);
    }

    @Test
    void getDamageDealtType() {
        this.creature.setDamageDealtType("magical");
        assertEquals(creature.getDamageDealtType(), "magical");
        assertNotEquals(creature.getDamageDealtType(), "wrong");
        assertNotNull(creature.getDamageDealtType());
    }

    @Test
    void setDamageDealtType() {
        this.creature.setDamageDealtType("magical");
        assertEquals(creature.getDamageDealtType(), "magical");
        assertNotEquals(creature.getDamageDealtType(), "wrong");
        assertNotNull(creature.getDamageDealtType());
    }

    @Test
    void getDamageDealt() {
        this.creature.setDamageDealt(20);
        assertEquals(creature.getDamageDealt(), 20);
        assertNotEquals(creature.getDamageDealt(), "wrong");
        assertNotNull(creature.getDamageDealt());
    }

    @Test
    void setDamageDealt() {
        this.creature.setDamageDealt(20);
        assertEquals(creature.getDamageDealt(), 20);
        assertNotEquals(creature.getDamageDealt(), "wrong");
        assertNotNull(creature.getDamageDealt());
    }

    @Test
    void getDefence() {
        assertEquals(creature.getDefense(), 20);
        assertNotEquals(creature.getDefense(), "wrong");
        assertNotNull(creature.getDefense());
    }

    @Test
    void getHealth() {
        assertEquals(creature.getHealth(), 20);
        assertNotEquals(creature.getHealth(), "wrong");
        assertNotNull(creature.getHealth());
    }

    @Test
    void setHealth() {
        this.creature.setHealth(21);
        assertEquals(creature.getHealth(), 21);
        assertNotEquals(creature.getHealth(), 20);
        assertNotNull(creature.getHealth());
    }

    @Test
    void getDamage() {
        assertEquals(creature.getDamage(), 20);
        assertNotEquals(creature.getDamage(), 21);
        assertNotNull(creature.getDamage());
    }

    @Test
    void setDamage() {
        this.creature.setDamage(21);
        assertEquals(creature.getDamage(), 21);
        assertNotEquals(creature.getDamage(), 20);
        assertNotNull(creature.getDamage());
    }

    @Test
    void isAlive() {
        assertTrue(this.creature.isAlive());
        this.creature.setHealth(0);
        assertFalse(this.creature.isAlive());
    }

    @Test
    void takeDamage() {
    }

    @Test
    void dealDamage() {
    }

}