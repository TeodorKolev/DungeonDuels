import cycle.Duel;
import models.base.Monster;
import models.base.Player;
import models.heroes.Mage;
import models.heroes.Warrior;
import models.monsters.GiantSpider;
import models.monsters.Skeleton;
import utils.Printer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Mage mage = new Mage("MagaMan");
        ArrayList<Monster> monsters = new ArrayList<>();
        Monster giantSpider = new Monster(new GiantSpider());
        Monster skeleton = new Monster(new Skeleton());
        monsters.add(giantSpider);
        monsters.add(skeleton);
        Duel duel = new Duel(mage, monsters);
        Printer.startLogo();
        duel.processDuel(Boolean.FALSE);
    }
}
