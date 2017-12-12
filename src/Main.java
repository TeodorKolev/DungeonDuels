import cycle.Duel;
import models.base.Monster;
import models.heroes.Mage;
import models.heroes.Warlock;
import models.heroes.Warrior;
import models.monsters.GiantSpider;
import models.monsters.Minotaur;
import models.monsters.Skeleton;
import utils.Printer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Warlock lock = new Warlock("MagaMan");
        ArrayList<Monster> monsters = new ArrayList<>();
        Skeleton skeleton = new Skeleton();
        GiantSpider giantSpider = new GiantSpider();
        Minotaur minotaur = new Minotaur();
        monsters.add(minotaur);
        monsters.add(skeleton);
        monsters.add(giantSpider);
        Duel duel = new Duel(lock, monsters);
        Printer.startLogo();
        duel.processDuel(Boolean.FALSE);
    }
}
