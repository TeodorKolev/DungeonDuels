package com.duels.dungeon.cycle;

import com.duels.dungeon.interfaces.IBonusDamager;
import com.duels.dungeon.interfaces.ISpellCaster;
import com.duels.dungeon.models.base.Monster;
import com.duels.dungeon.models.base.Player;
import com.duels.dungeon.models.heroes.Mage;
import com.duels.dungeon.models.heroes.Warlock;
import com.duels.dungeon.models.heroes.Warrior;
import com.duels.dungeon.utils.Printer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Duel {

    private Player player;
    private ArrayList<Monster> monsters;
    private Scanner scanner;
    private Monster monster;
    private int round;

    public Duel(ArrayList<Monster> monsters) {
        this.monsters = monsters;
        this.scanner = new Scanner(System.in);
    }

    private Player getPlayer() {
        return player;
    }

    private ArrayList<Monster> getMonsters() {
        return monsters;
    }

    private void setMonster(ArrayList<Monster> monsters, int position) {
        this.monster = monsters.get(position);
    }

    private Monster getMonster() {
        return monster;
    }

    private int getRound() {
        return round;
    }

    private void setRound(int round) {
        this.round = round;
    }

    public void play() {
        Printer.startLogo();
        this.setRound(0);
        this.setUpPlayer();
        this.setUpMonster(this.getMonsters(), this.getRound());
        this.processDuel(Boolean.FALSE);
    }

    private void setUpPlayer() {
        this.player = this.setPlayerClass(this.selectPlayerClass(), this.setPlayerName());
    }

    private void setUpMonster(ArrayList<Monster> monsters, int position) {
        this.setMonster(monsters, position);
        Printer.faceEnemy(player.getName(), this.getMonster().getName());
    }

    private String setPlayerName() {
        Printer.chooseName();
        String name = scanner.next();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    private int selectPlayerClass() {
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

    private Player setPlayerClass(int playerClass, String playerName) {
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

    private void duelPhase(Player player, Monster monster, int round, ArrayList<Monster> monsters) {
        this.playerTurn(player, monster);
        if (monster.isAlive()) {
            this.monsterTurn(player, monster);
            if (player.isAlive()) {
                this.processDuel(Boolean.TRUE);
            } else {
                this.monsterDefeatPlayer();
            }
        } else {
            this.playerDefeatMonster(player, monster, round, monsters);
        }
    }

    private void monsterDefeatPlayer() {
        Printer.monsterDefeatPlayer();
    }

    private void playerDefeatMonster(Player player, Monster monster, int round, ArrayList<Monster> monsters) {
        Printer.playerDefeatMonster(player.getName(), monster.getName());
        this.setRound(round += 1);
        if (round + 1 > monsters.size()) {
            Printer.victory(player.getName());
        } else {
            this.faceNextEnemy(monsters, round, player);
        }
        this.scanner.close();
    }

    private void faceNextEnemy(ArrayList<Monster> monsters, int round, Player player) {
        this.setUpMonster(monsters, round);
        player.replenishLife();
        this.processDuel(Boolean.FALSE);
    }

    private void playerTurn(Player player, Monster monster) {
        this.attack(player, monster, Boolean.TRUE);
        monster.defense(player.getDamageDealt(), player.getDamageDealtType());
        if (player instanceof ISpellCaster) {
            this.castSpecial(player, monster, Boolean.TRUE);
        }
    }

    private void monsterTurn(Player player, Monster monster) {
        this.attack(player, monster, Boolean.FALSE);
        player.defense(monster.getDamageDealt(), monster.getDamageDealtType());
        if (monster instanceof ISpellCaster) {
            this.castSpecial(player, monster, Boolean.FALSE);
        }
    }

    private void attack(Player player, Monster monster, boolean heroCast) {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        if (heroCast) {
            if (player instanceof IBonusDamager) {
                ((IBonusDamager) player).empowerAttack(randomInt);
                ((IBonusDamager) player).resetDamage();
            } else {
                player.attack();
            }
        } else {
            if (monster instanceof IBonusDamager) {
                ((IBonusDamager) monster).empowerAttack(randomInt);
                ((IBonusDamager) monster).resetDamage();
            } else {
                monster.attack();
            }
        }
    }

    private void castSpecial(Player player, Monster monster, boolean heroCast) {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        if (heroCast) {
            if (player instanceof Warlock) {
                ((Warlock) player).specialPenalty(randomInt);
            } else {
                if (randomInt <= (((ISpellCaster) player).getSpecialPowerCastChance())) {
                    ((ISpellCaster) player).castSpecial();
                    monster.defense(player.getDamageDealt(), player.getDamageDealtType());
                }
            }
        } else {
            if (randomInt <= (((ISpellCaster) monster).getSpecialPowerCastChance())) {
                ((ISpellCaster) monster).castSpecial();
                player.defense(monster.getDamageDealt(), monster.getDamageDealtType());
            }
        }
    }

    private void processDuel(boolean duelPhase) {
        if (duelPhase == Boolean.TRUE) {
            Printer.processDuelPhase();
        } else {
            Printer.beginDuel();
        }
        this.scanner.nextLine();
        if (this.scanner.hasNextLine()) {
            this.duelPhase(this.getPlayer(), this.getMonster(), this.getRound(), this.getMonsters());
        }
    }

}