package com.duels.dungeon.cycle;

import com.duels.dungeon.models.creature.monster.Monster;
import com.duels.dungeon.models.creature.monster.monsters.GiantSpider;
import com.duels.dungeon.models.creature.monster.monsters.Skeleton;
import com.duels.dungeon.models.creature.player.Player;
import com.duels.dungeon.models.creature.player.heroes.Warlock;
import com.duels.dungeon.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class TurnTest {

    private AttackPhase attackPhase;
    private CastingPhase castingPhase;
    private Turn turn;
    private Player player;
    private String playerName;
    private Monster monster;
    private GiantSpider castableMonster;


    @Before
    public void setUp() throws Exception {
        this.playerName = "playerName";
        this.attackPhase = Mockito.spy(new AttackPhase());
        this.castingPhase = Mockito.spy(new CastingPhase());
        this.player = Mockito.spy(new Warlock(playerName));
        this.monster = Mockito.spy(new Skeleton());
        this.castableMonster = Mockito.spy(new GiantSpider());
        this.turn = new Turn();
    }

    @Test
    public void playerTurn() {
        Mockito.doNothing().when(attackPhase).attack(player, monster, Boolean.TRUE);
        Mockito.doNothing().when(monster).defense(Mockito.anyInt(), Mockito.anyString());
        Mockito.doNothing().when(castingPhase).castSpecial(player, monster, Boolean.TRUE);
        turn.playerTurn(player, monster);
        attackPhase.attack(player, monster, Boolean.TRUE);
        castingPhase.castSpecial(player, monster, Boolean.TRUE);
        Mockito.verify(attackPhase).attack(player, monster, Boolean.TRUE);
        Mockito.verify(monster).defense(Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(castingPhase).castSpecial(player, monster, Boolean.TRUE);
    }

    @Test
    public void monsterTurnNonCastable() {
        Mockito.doNothing().when(attackPhase).attack(player, monster, Boolean.FALSE);
        Mockito.doNothing().when(player).defense(Mockito.anyInt(), Mockito.anyString());
        Mockito.doNothing().when(castingPhase).castSpecial(player, monster, Boolean.FALSE);
        turn.monsterTurn(player, monster);
        attackPhase.attack(player, monster, Boolean.FALSE);
        Mockito.verify(attackPhase).attack(player, monster, Boolean.FALSE);
        Mockito.verify(player).defense(Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(castingPhase, Mockito.never()).castSpecial(player, monster, Boolean.FALSE);
    }

    @Test
    public void monsterTurnCastable() {
        Mockito.doNothing().when(attackPhase).attack(player, castableMonster, Boolean.FALSE);
        Mockito.doNothing().when(player).defense(Mockito.anyInt(), Mockito.anyString());
        Mockito.doNothing().when(castingPhase).castSpecial(player, castableMonster, Boolean.FALSE);
        turn.monsterTurn(player, castableMonster);
        attackPhase.attack(player, castableMonster, Boolean.FALSE);
        castingPhase.castSpecial(player, castableMonster, Boolean.FALSE);
        Mockito.verify(attackPhase).attack(player, castableMonster, Boolean.FALSE);
        Mockito.verify(player).defense(Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(castingPhase).castSpecial(player, castableMonster, Boolean.FALSE);
    }
}