package cycle;

import interfaces.iCastable;
import models.base.Monster;
import models.base.Player;
import utils.Constants;
import utils.Printer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Duel {

    private Player player;
    private ArrayList<Monster> monsters;
    private Scanner scanner;
    private Monster monster;
    private int round = 0;

    public Duel(Player player, ArrayList<Monster> monsters) {
        this.player = player;
        this.monsters = monsters;
        this.scanner = new Scanner(System.in);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Monster getMonster(ArrayList<Monster> monsters, int position) {
        return monsters.get(position);
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void start() {
        this.setMonster(this.getMonster(this.monsters, this.getRound()));
        player.attack();
        monster.defense(player.getCreature().getDamageDealt(), player.getCreature().getDamageDealtType());
        if (iCastable.class.isAssignableFrom(player.getCreature().getClass())) {
            this.castSpecial(player, monster, Boolean.TRUE);
        }
        if (monster.getCreature().getHealth() > 0) {
            monster.attack();
            player.defense(monster.getCreature().getDamageDealt(), monster.getCreature().getDamageDealtType());
            if (iCastable.class.isAssignableFrom(monster.getCreature().getClass())) {
                this.castSpecial(player, monster, Boolean.FALSE);
            }
            if (player.getCreature().getHealth() > 0) {
                this.processDuel(Boolean.TRUE);
            } else {
                Printer.monsterDefeatPlayer(player.getName());
            }
        } else {
            Printer.playerDefeatMonster(player.getName(), monster.getCreature().getName());
            this.setRound(this.getRound() + 1);
            if (this.getRound() + 1 > this.monsters.size()) {
                Printer.victory(this.getPlayer().getName());
            } else {
                this.setMonster(this.getMonster(this.monsters, this.getRound()));
                this.player.replenishLife();
                this.processDuel(Boolean.FALSE);
            }
        }
    }

    private void castSpecial(Player playerCreature, Monster monsterCreature, boolean heroCast) {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        if (heroCast) {
            if (randomInt <= playerCreature.getSpecialPowerCastChance()) {
                playerCreature.castSpecial();
                if (playerCreature.getSpecialPower().getTarget().equals(Constants.TARGET_ENEMY)) {
                    monsterCreature.defense(playerCreature.getCreature().getDamageDealt(),
                            playerCreature.getCreature().getDamageDealtType());
                }
            }
        } else {
            if (randomInt <= monsterCreature.getSpecialPowerCastChance()) {
                monsterCreature.castSpecial();
                if (monsterCreature.getSpecialPower().getTarget().equals(Constants.TARGET_ENEMY)) {
                    playerCreature.defense(monsterCreature.getCreature().getDamageDealt(),
                            monsterCreature.getCreature().getDamageDealtType());
                }
            }
        }
    }

    public void processDuel(boolean phase) {
        if (phase == Boolean.TRUE) {
            Printer.processDuelPhase();
        } else {
            Printer.stepDeeper();
        }
        scanner.hasNextLine();
        if (scanner.hasNextLine()) {
            scanner.nextLine();
            this.start();
        }
    }

}
