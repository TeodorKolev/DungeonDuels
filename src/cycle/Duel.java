package cycle;

import interfaces.iCastable;
import models.base.Monster;
import models.base.Player;
import utils.Printer;

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
        Printer.printStartLogo();
        hero.attack();
        monster.defense(hero.getCreature().getDamageDealt(), hero.getCreature().getDamageDealtType());
        if (iCastable.class.isAssignableFrom(hero.getCreature().getClass())) {
            // TODO cast spell
        }
        monster.attack();
        if (iCastable.class.isAssignableFrom(monster.getCreature().getClass())) {
            // TODO cast spell
        }
    }

}
