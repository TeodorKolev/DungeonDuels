package cycle;

import interfaces.iCastable;
import models.base.Monster;
import models.base.Player;
import utils.Constants;
import utils.Printer;

import java.util.Random;

public class Duel {

    private Player hero;
    private Monster monster;

    private int round;

    public Duel(Player hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

    public Player getHero() {
        return hero;
    }

    public void setHero(Player hero) {
        this.hero = hero;
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
        hero.attack();
        monster.defense(hero.getCreature().getDamageDealt(), hero.getCreature().getDamageDealtType());
        if (iCastable.class.isAssignableFrom(hero.getCreature().getClass())) {
            Random r = new Random();
            int randomInt = r.nextInt(100) + 1;
            if (randomInt <= hero.getSpecialChance()) {
                hero.castSpecial();
                if (hero.getSpecialPower().getTarget().equals(Constants.TARGET_ENEMY)) {
                    monster.defense(hero.getCreature().getDamageDealt(), hero.getCreature().getDamageDealtType());
                }
            }
        }

        monster.attack();
        hero.defense(monster.getCreature().getDamageDealt(), monster.getCreature().getDamageDealtType());
        if (iCastable.class.isAssignableFrom(monster.getCreature().getClass())) {
            // TODO cast spell
        }
    }

}
