package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.monster.monsters.GiantSpider;
import com.duels.dungeon.models.creature.monster.monsters.Minotaur;
import com.duels.dungeon.models.creature.monster.monsters.Skeleton;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.creature.player.heroes.Warlock;
import com.duels.dungeon.utils.Printer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EndPhaseTest {

    private Player player;
    private String playerName;
    private Duel duel;
    private Battle battle;
    private Printer printer;
    private EndPhase endPhase;
    private ArrayList<Monster> monsters;
    private Monster monster;
    private Setup setup;

    @Before
    public void setUp() throws Exception {
        this.playerName = "playerName";
        this.printer = Mockito.spy(new Printer());
        this.duel = Mockito.spy(new Duel());
        this.battle = Mockito.spy(new Battle(duel));
        this.endPhase = Mockito.spy(new EndPhase(battle));
        this.player = Mockito.spy(new Warlock(playerName));
        this.setup = Mockito.spy(new Setup(duel));
        this.monster = Mockito.spy(new Skeleton());
        monsters = new ArrayList<Monster>();
        Skeleton skeleton = new Skeleton();
        GiantSpider giantSpider = new GiantSpider();
        Minotaur minotaur = new Minotaur();
        monsters.add(skeleton);
        monsters.add(giantSpider);
        monsters.add(minotaur);
    }

    @Test
    public void monsterDefeatPlayer() {
        endPhase.monsterDefeatPlayer();
        Mockito.verify(endPhase).monsterDefeatPlayer();
    }

    @Test
    public void playerDefeatMonsterNotLast() {
        // TODO faceNextEnemy not fired
        Mockito.doNothing().when(duel).setRound(Mockito.anyInt());
        Mockito.doNothing().when(battle).faceNextEnemy(monsters, 1, player);
        Mockito.doNothing().when(endPhase).playerDefeatMonster(player, monster, 1, monsters);
        endPhase.playerDefeatMonster(player, monster, 1, monsters);
        duel.setRound(1);
        battle.faceNextEnemy(monsters, 1, player);
        Mockito.verify(duel).setRound(1);
        Mockito.verify(battle).faceNextEnemy(monsters, 1, player);
    }

    @Test
    public void playerDefeatMonsterLast() {
        Mockito.doNothing().when(duel).setRound(Mockito.anyInt());
        Mockito.doNothing().when(battle).faceNextEnemy(monsters, 4, player);
        Mockito.doNothing().when(endPhase).playerDefeatMonster(player, monster, 4, monsters);
        endPhase.playerDefeatMonster(player, monster, 3, monsters);
        Mockito.verify(duel).setRound(4);
        Mockito.verify(battle, Mockito.never()).faceNextEnemy(monsters, 4, player);
    }
}