package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.monsters.Skeleton;
import com.duels.dungeon.models.creature.player.heroes.Warrior;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class BattleTest {

    private Turn turn;
    private EndPhase endPhase;
    private Scanner scanner;
    private Duel duel;
    private Battle battle;
    private Warrior warrior;
    private Skeleton skeleton;
    private String playerName;

    @Before
    public void setUp() throws Exception {
        this.playerName = "playerTest";
        this.scanner = new Scanner(System.in);
        this.duel = Mockito.spy(new Duel());
        this.battle = Mockito.spy(new Battle(duel));
        this.endPhase = Mockito.spy(new EndPhase(battle));
        this.turn = Mockito.spy(new Turn());
        this.warrior = Mockito.spy(new Warrior(playerName));
        this.skeleton = Mockito.spy(new Skeleton());
        assertNotNull(scanner);
        assertNotNull(duel);
        assertNotNull(battle);
        assertNotNull(endPhase);
        assertNotNull(turn);
    }

    @Test
    public void getDuel() {
        battle.getDuel();
        assertNotNull(this.battle.getDuel());
    }

    @Test
    public void processDuel() {
        // TODO
    }

    @Test
    public void faceNextEnemy() {
        // TODO
    }
}