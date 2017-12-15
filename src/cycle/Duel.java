package cycle;

import interfaces.IBonusDamager;
import interfaces.ISpellCaster;
import models.base.Creature;
import models.base.Monster;
import models.base.Player;
import models.heroes.Warlock;
import utils.Printer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Duel {

    private Player player;
    private ArrayList<Monster> monsters;
    private Scanner scanner;
    private Monster monster;
    private int round = 1;

    public Duel(Player player, ArrayList<Monster> monsters) {
        this.player = player;
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

    private void start() {
        this.setMonster(this.getMonsters(), this.getRound());
        this.setUpDuel(this.getPlayer(), this.getMonster(), this.getRound(), this.getMonsters());
    }

    private void setUpDuel(Player player, Monster monster, int round, ArrayList<Monster> monsters) {
        this.playerTurn(player, monster);
        if (isAlive(monster)) {
            this.monsterTurn(player, monster);
            if (isAlive(player)) {
                this.processDuel(Boolean.TRUE);
            } else {
                this.monsterDefeatPlayer(player);
            }
        } else {
            this.playerDefeatMonster(player, monster, round, monsters);
        }
    }

    private boolean isAlive(Creature creature) {
        return creature.getHealth() > 0;
    }

    private void monsterDefeatPlayer(Player player) {
        Printer.monsterDefeatPlayer(player.getName());
    }

    private void playerDefeatMonster(Player player, Monster monster, int round, ArrayList<Monster> monsters) {
        Printer.playerDefeatMonster(player.getName(), monster.getName());
        this.setRound(round + 1);
        if (round > monsters.size()) {
            Printer.victory(player.getName());
        } else {
            this.faceNextEnemy(monsters, round, player);
        }
    }

    private void faceNextEnemy(ArrayList<Monster> monsters, int round, Player player) {
        setMonster(monsters, round);
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
                ((ISpellCaster) player).castSpecial();
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

    public void processDuel(boolean phase) {
        if (this.getRound() == 1) {
            Printer.welcome();
        } else {
            if (phase == Boolean.TRUE) {
                Printer.processDuelPhase();
            } else {
                Printer.stepDeeper();
            }
        }
        scanner.hasNextLine();
        if (scanner.hasNextLine()) {
            scanner.nextLine();
            if (this.getRound() == 1) {
                this.start();
            } else {
                this.setUpDuel(this.getPlayer(), this.getMonster(), this.getRound(), this.getMonsters());
            }
        }
    }

}
