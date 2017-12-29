package com.duels.dungeon.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntityTest {

    private Entity entity;
    private String entityName;

    @Before
    public void setUp() throws Exception {
        this.entityName = "entityName";
        this.entity = new Entity(entityName);
    }

    @Test
    public void getName() {
        entity.getName();
        assertNotNull(entity.getName());
        assertEquals(entityName, entity.getName());
    }
}