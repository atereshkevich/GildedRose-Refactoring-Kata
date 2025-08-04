package com.gildedrose.strategy;

import com.gildedrose.domain.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieUpdateStrategyTest {

    private final AgedBrieUpdateStrategy strategy = new AgedBrieUpdateStrategy();

    @Test
    public void increasesQualityBeforeSellIn() {
        // Quality should increase by 1 when sellIn > 0
        Item item = new Item("Aged Brie", 2, 0);
        strategy.update(item);
        assertEquals(1, item.quality());
        assertEquals(1, item.sellIn());
    }

    @Test
    public void increasesQualityTwiceAfterSellIn() {
        // Quality should increase by 2 when sellIn <= 0 (once before and once after expiration)
        Item item = new Item("Aged Brie", 0, 0);
        strategy.update(item);
        assertEquals(2, item.quality());
        assertEquals(-1, item.sellIn());
    }

    @Test
    public void qualityDoesNotExceed50() {
        // Quality should not increase if it is already at the max (50)
        Item item = new Item("Aged Brie", 2, 50);
        strategy.update(item);
        assertEquals(50, item.quality());
    }

    @Test
    public void qualityDoesNotExceed50AfterExpiration() {
        // Quality should only reach 50 after expiration, not exceed it
        Item item = new Item("Aged Brie", 0, 49);
        strategy.update(item);
        assertEquals(50, item.quality());
        assertEquals(-1, item.sellIn());
    }

    @Test
    public void nothingHappensIfQualityIsAlready50AndExpired() {
        // If quality is at max and item is expired, nothing should change except sellIn
        Item item = new Item("Aged Brie", -1, 50);
        strategy.update(item);
        assertEquals(50, item.quality());
        assertEquals(-2, item.sellIn());
    }
}
