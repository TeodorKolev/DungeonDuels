package cycle;

import interfaces.iCastable;
import models.base.Monster;
import models.base.Player;
import utils.Constants;
import utils.Printer;

import java.util.Random;

public class Duel {

    private Player player;
    private Monster monster;

    private int round;

    public Duel(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void start() {
        Printer.startLogo();
        player.attack();
        monster.defense(player.getCreature().getDamageDealt(), player.getCreature().getDamageDealtType());
        if (iCastable.class.isAssignableFrom(player.getCreature().getClass())) {
            this.castSpecial(player, monster, Boolean.TRUE);
        }
        monster.attack();
        player.defense(monster.getCreature().getDamageDealt(), monster.getCreature().getDamageDealtType());
        if (iCastable.class.isAssignableFrom(monster.getCreature().getClass())) {
            this.castSpecial(player, monster, Boolean.FALSE);
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

}
