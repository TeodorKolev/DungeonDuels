package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.utils.Printer;

import java.util.ArrayList;

public class Setup {

    private Duel duel;
    private ClassSelector classSelector;
    private NameSelector nameSelector;

    public Setup(Duel duel) {
        this.duel = duel;
        this.classSelector = new ClassSelector();
        this.nameSelector = new NameSelector();
    }

    public void setUpPlayer() {
       duel.setPlayer(classSelector.setPlayerClass(classSelector.selectPlayerClass(), nameSelector.setPlayerName()));
    }

    public void setUpMonster(ArrayList<Monster> monsters, int position) {
        duel.setMonster(monsters, position);
        Printer.faceEnemy(duel.getPlayer().getName(), duel.getMonster().getName());
    }
}
