package com.duels.dungeon.cycle;

import com.duels.dungeon.models.base.Player;
import com.duels.dungeon.models.heroes.Mage;
import com.duels.dungeon.models.heroes.Warlock;
import com.duels.dungeon.models.heroes.Warrior;
import com.duels.dungeon.utils.Printer;

import java.util.Scanner;

public class ClassSelector {

    private Scanner scanner;

    public ClassSelector() {
        this.scanner = new Scanner(System.in);
    }

    public int selectPlayerClass() {
        int number;
        do {
            Printer.chooseClass();
            while (!scanner.hasNextInt()) {
                Printer.invalidInput();
                scanner.nextLine();
            }
            number = scanner.nextInt();
        } while (number != 1 && number != 2 && number != 3);
        return number;
    }

    public Player setPlayerClass(int playerClass, String playerName) {
        switch (playerClass) {
            case 1:
                return new Warrior(playerName);
            case 2:
                return new Mage(playerName);
            case 3:
                return new Warlock(playerName);
            default:
                throw new IllegalArgumentException(Printer.invalidPlayerClass + playerClass);
        }
    }
}
