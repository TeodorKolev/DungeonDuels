import cycle.GameCycle;
import models.heroes.Warrior;

public class Main {

    public static void main(String[] args) {

        Warrior warr = new Warrior("Warrr");
        GameCycle gameCycle = new GameCycle(warr, warr);
        gameCycle.start();
    }
}
