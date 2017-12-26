package com.duels.dungeon.cycle;

import com.duels.dungeon.utils.Printer;

import java.util.Scanner;

/**
 * Represents an name selector.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class NameSelector {

    private Scanner scanner;

    /**
     * Creates an name selector.
     * Defines scanner. Type Scanner class.
     */
    public NameSelector() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Sets player name from user input and capitalize it.
     * @return player name. Type String.
     */
    public String setPlayerName() {
        Printer.chooseName();
        String name = scanner.next();
        // Capitalize first letter.
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
