package com.duels.dungeon.cycle;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.Assert.*;

public class BattleTest {

    private Turn turn;
    private EndPhase endPhase;
    private Scanner scanner;
    private Duel duel;
    private Battle battle;

    @Before
    public void setUp() throws Exception {
        this.scanner = new Scanner(System.in);
        this.duel = Mockito.spy(new Duel());
        this.battle = Mockito.spy(new Battle(duel));
        this.endPhase = Mockito.spy(new EndPhase(battle));
        this.turn = Mockito.spy(new Turn());
        assertNotNull(scanner);
        assertNotNull(duel);
        assertNotNull(battle);
        assertNotNull(endPhase);
        assertNotNull(turn);
    }

    @Test
    public void getDuel() {
        assertNotNull(this.battle.getDuel());
    }

    @Test
    public void processDuel() {

    }

    @Test
    public void faceNextEnemy() {
    }
}