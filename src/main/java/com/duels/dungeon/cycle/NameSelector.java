package com.duels.dungeon.cycle;

import com.duels.dungeon.utils.Printer;

import java.util.Scanner;

public class NameSelector {

    private Scanner scanner;

    public NameSelector() {
        this.scanner = new Scanner(System.in);
    }

    public String setPlayerName() {
        Printer.chooseName();
        String name = scanner.next();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
