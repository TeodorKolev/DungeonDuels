import cycle.GameCycle;
import models.base.Player;
import models.heroes.Mage;
import models.heroes.Warrior;

public class Main {

    public static void main(String[] args) {

        Player warr = new Player(new Mage("Warrr"));
        GameCycle gameCycle = new GameCycle(warr, warr);
        gameCycle.start();
    }
}
