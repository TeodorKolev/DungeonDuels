import cycle.Duel;
import models.base.Monster;
import models.heroes.Mage;
import models.heroes.Warrior;
import models.monsters.GiantSpider;
import models.monsters.Skeleton;
import utils.Printer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Warrior mage = new Warrior("MagaMan");
        ArrayList<Monster> monsters = new ArrayList<>();
        Skeleton skeleton = new Skeleton();
        GiantSpider giantSpider = new GiantSpider();
        monsters.add(skeleton);
        monsters.add(giantSpider);
        Duel duel = new Duel(mage, monsters);
        Printer.startLogo();
        duel.processDuel(Boolean.FALSE);
    }
}
