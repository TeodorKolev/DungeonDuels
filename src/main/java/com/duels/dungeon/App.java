package main.java.com.duels.dungeon;
import com.duels.dungeon.cycle.Duel;
import com.duels.dungeon.models.base.Monster;
import com.duels.dungeon.models.monsters.GiantSpider;
import com.duels.dungeon.models.monsters.Minotaur;
import com.duels.dungeon.models.monsters.Skeleton;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        ArrayList<Monster> monsters = new ArrayList<Monster>();

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
