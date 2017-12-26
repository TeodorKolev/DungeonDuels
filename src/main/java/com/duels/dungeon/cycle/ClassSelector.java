package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.creature.player.heroes.Mage;
import com.duels.dungeon.models.creature.player.heroes.Warlock;
import com.duels.dungeon.models.creature.player.heroes.Warrior;
import com.duels.dungeon.utils.Constants;
import com.duels.dungeon.utils.Printer;

import java.util.Scanner;

/**
 * Represents an duel class selector.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class ClassSelector {

    private Scanner scanner;

    /**
     * Creates an class selector.
     * Defines scanner. Type Scanner class.
     */
    public ClassSelector() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Select a player. Select player according to user input.
     * Use integer for class id's. Validate input. Proceed only on valid input.
     */
    public int selectPlayerClass() {
        int number;
        do {
            Printer.chooseClass();
            while (!scanner.hasNextInt()) {
                Printer.invalidInput();
                scanner.nextLine();
            }
            number = scanner.nextInt();
        } while (number != Constants.WARRIOR_ID && number != Constants.MAGE_ID && number != Constants.WARLOCK_ID);
        return number;
    }

    /**
     * Set a player class according to predefined id and name.
     * @param playerClass predefined number parameter. Type int.
     * @param playerName predefined name parameter. Type String.
     * @return Different Creature class child.
     * @throws IllegalArgumentException on invalid number parameter.
     */
    public Player setPlayerClass(int playerClass, String playerName) {
        switch (playerClass) {
            case Constants.WARRIOR_ID:
                return new Warrior(playerName);
            case Constants.MAGE_ID:
                return new Mage(playerName);
            case Constants.WARLOCK_ID:
                return new Warlock(playerName);
            default:
                throw new IllegalArgumentException(Printer.invalidPlayerClass + playerClass);
        }
    }
}
