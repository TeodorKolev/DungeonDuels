package com.duels.dungeon.models;

/**
 * Represents an entity.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class Entity {

    private String name;

    /**
     * Creates entity.
     * @param name object. Type String.
     */
    public Entity(String name) {
        this.name = name;
    }

    /**
     * Retrieve entity's name.
     * @return current entity's name. Type String.
     */
    public String getName() {
        return name;
    }

}
