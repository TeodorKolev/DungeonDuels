import cycle.Duel;
import models.base.Monster;
import models.monsters.GiantSpider;
import models.monsters.Minotaur;
import models.monsters.Skeleton;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Monster> monsters = new ArrayList<>();

        Skeleton skeleton = new Skeleton();
        GiantSpider giantSpider = new GiantSpider();
        Minotaur minotaur = new Minotaur();

        monsters.add(skeleton);
        monsters.add(giantSpider);
        monsters.add(minotaur);

        Duel duel = new Duel(monsters);
        duel.play();
    }


}
