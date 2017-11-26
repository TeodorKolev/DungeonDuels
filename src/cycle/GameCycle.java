package cycle;

import models.base.Creature;
import models.base.Player;
import models.heroes.Mage;
import models.heroes.Warrior;

public class GameCycle {

    private Player hero;
    private Player monster;

    private int round;

    public GameCycle(Player hero, Player monster) {
        this.hero = hero;
        this.monster = monster;
    }

    public Player getHero() {
        return hero;
    }

    public void setHero(Player hero) {
        this.hero = hero;
    }

    public Player getMonster() {
        return monster;
    }

    public void setMonster(Player monster) {
        this.monster = monster;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void start() {
        hero.attack();
    }

}
