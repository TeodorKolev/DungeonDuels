import cycle.Duel;
import models.base.Monster;
import models.base.Player;
import models.heroes.Warrior;
import models.monsters.GiantSpider;
import models.monsters.Skeleton;
import utils.Printer;

public class Main {

    public static void main(String[] args) {

        Player war = new Player("Warr", new Warrior());
        Monster skeleton = new Monster(new GiantSpider());
        Duel duel = new Duel(war, skeleton);
        Printer.startLogo();
        duel.processDuel();
    }
}
