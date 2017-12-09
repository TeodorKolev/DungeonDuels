import cycle.Duel;
import models.base.Monster;
import models.base.Player;
import models.heroes.Warrior;
import models.monsters.GiantSpider;
import models.monsters.Skeleton;
import utils.Printer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Player war = new Player("Warr", new Warrior());
        Monster giantSpider = new Monster(new GiantSpider());
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(giantSpider);
        Duel duel = new Duel(war, monsters);
        Printer.startLogo();
        duel.processDuel();
    }
}
