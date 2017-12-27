package com.duels.dungeon.models.creature.monster.monsters;

import com.duels.dungeon.models.creature.Creature;
import com.duels.dungeon.models.spell.spells.SpiderVenom;
import com.duels.dungeon.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class GiantSpiderTest {

    private GiantSpider giantSpider;
    private Creature creature;
    private SpiderVenom spiderVenom;
    private int spiderVenomDamage;

    @Before
    public void setUp() throws Exception {
        this.spiderVenomDamage = 14;
        this.giantSpider = new GiantSpider();
        this.creature = Mockito.spy(new Creature(
                Constants.GIANT_SPIDER, Constants.GIANT_SPIDER_HEALTH,
                Constants.GIANT_SPIDER_DAMAGE, Constants.GIANT_SPIDER_DEFENSE));
        this.spiderVenom = Mockito.spy(new SpiderVenom(spiderVenomDamage));
        assertNotNull(giantSpider);
        assertNotNull(creature);
        assertNotNull(spiderVenom);
    }

    @Test
    public void attack() {
        Mockito.doNothing().when(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        creature.dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        giantSpider.attack();
        Mockito.verify(creature).dealDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void defense() {
        Mockito.doNothing().when(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        giantSpider.defense(15, Constants.DAMAGE_TYPE_PHYSICAL);
        creature.takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(creature).takeDamage(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void getSpecialPower() {
        assertEquals(SpiderVenom.class, giantSpider.getSpecialPower().getClass());
    }

    @Test
    public void getSpecialPowerCastChance() {
        assertEquals(Constants.GIANT_SPIDER_CAST_SPECIAL_CHANCE, giantSpider.getSpecialPowerCastChance());
    }

    @Test
    public void castSpecial() {
        Mockito.doNothing().when(creature).setDamageDealt(Mockito.anyInt());
        Mockito.doNothing().when(creature).setDamageDealtType(Mockito.anyString());
        giantSpider.castSpecial();
        creature.setDamageDealt(spiderVenomDamage);
        creature.setDamageDealtType(Constants.DAMAGE_TYPE_MAGIC);
        Mockito.verify(creature).setDamageDealt(Mockito.anyInt());
        Mockito.verify(creature).setDamageDealtType(Mockito.anyString());
        assertEquals(spiderVenomDamage, giantSpider.getSpecialPower().getDamage());
    }
}