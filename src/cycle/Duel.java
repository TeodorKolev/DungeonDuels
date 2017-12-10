package cycle;

import interfaces.ISpellCaster;
import models.base.Creature;
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
        // TODO refactor just for start
        this.setMonster(this.getMonsters(), this.getRound());
        this.setUpDuel(this.getPlayer(), this.getMonster(), this.getRound(), this.getMonsters());
    }

    private void setUpDuel(Player player, Monster monster, int round, ArrayList<Monster> monsters) {
        this.playerTurn(player, monster);
        if (isAlive(monster.getCreature())) {
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
        Printer.playerDefeatMonster(player.getName(), monster.getCreature().getName());
        this.setRound(round + 1);
        if (this.getRound() + 1 > monsters.size()) {
            Printer.victory(player.getName());
        } else {
            this.faceNextEnemy(monsters, this.getRound(), player);
        }
    }

    private boolean isPlayerCastable(Player player) {
        return ISpellCaster.class.isAssignableFrom(player.getClass());
    }

    private boolean isMonsterCastable(Monster monster) {
        return ISpellCaster.class.isAssignableFrom(monster.getCreature().getClass());
    }

    private void faceNextEnemy(ArrayList<Monster> monsters, int round, Player player) {
        setMonster(monsters, round);
        player.replenishLife();
        this.processDuel(Boolean.FALSE);
    }

    private void playerTurn(Player player, Monster monster) {
        player.attack();
        monster.defense(player.getDamageDealt(), player.getDamageDealtType());
        if (isPlayerCastable(player)) {
            this.castSpecial(player, monster, Boolean.TRUE);
        }
    }

    private void monsterTurn(Player player, Monster monster) {
        monster.attack();
        player.defense(monster.getCreature().getDamageDealt(),
                monster.getCreature().getDamageDealtType());
        if (isMonsterCastable(monster)) {
            this.castSpecial(player, monster, Boolean.FALSE);
        }
    }

    private void castSpecial(Player player, Monster monster, boolean heroCast) {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        if (heroCast) {
            if (player instanceof ISpellCaster) {
                if (randomInt <= ((ISpellCaster) player).getSpecialPowerCastChance()) {
                    ((ISpellCaster) player).castSpecial();
                    if (((ISpellCaster) player).getSpecialPower().getTarget().equals(Constants.TARGET_ENEMY)) {
                        monster.defense(player.getDamageDealt(), player.getDamageDealtType());
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } else {
            if (randomInt <= monster.getSpecialPowerCastChance()) {
                monster.castSpecial();
                if (monster.getSpecialPower().getTarget().equals(Constants.TARGET_ENEMY)) {
                    player.defense(monster.getCreature().getDamageDealt(), monster.getCreature().getDamageDealtType());
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
            // TODO distinguish start from levels
            this.start();
        }
    }

}
