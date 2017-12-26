package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.utils.Printer;

import java.util.ArrayList;

/**
 * Represents an duel setup.
 * @author Teodor Kolev
 * @author https://github.com/TeodorKolev
 * @version 1.0
 * @since 1.0
 */
public class Setup {

    private Duel duel;
    private ClassSelector classSelector;
    private NameSelector nameSelector;

    /**
     * Creates setup.
     * Defines class selector. Type ClassSelector class.
     * Defines name selector. Type NameSelector class.
     * @param duel object. Type Duel class.
     */
    public Setup(Duel duel) {
        this.duel = duel;
        this.classSelector = new ClassSelector();
        this.nameSelector = new NameSelector();
    }

    /**
     * Setup player. Define player in duel class according to user input class and name.
     */
    public void setUpPlayer() {
       duel.setPlayer(classSelector.setPlayerClass(classSelector.selectPlayerClass(), nameSelector.setPlayerName()));
    }

    /**
     * Setup monster. Define monster in duel class according to
     * predefined monsters array and position. Prints result.
     * @param monsters array. Type ArrayList from Monster object.
     * @param position number. Type int.
     */
    public void setUpMonster(ArrayList<Monster> monsters, int position) {
        duel.setMonster(monsters, position);
        Printer.faceEnemy(duel.getPlayer().getName(), duel.getMonster().getName());
    }
}
