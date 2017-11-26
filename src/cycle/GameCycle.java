package cycle;

import models.base.Creature;
import models.heroes.Mage;
import models.heroes.Warrior;

public class GameCycle {

    private Creature hero;
    private Creature monster;

    private int round;

    public GameCycle(Creature hero, Creature monster) {
        this.hero = hero;
        this.monster = monster;
    }

    public Creature getHero() {
        return hero;
    }

    public void setHero(Creature hero) {
        this.hero = hero;
    }

    public Creature getMonster() {
        return monster;
    }

    public void setMonster(Creature monster) {
        this.monster = monster;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void start() {

    }

}
