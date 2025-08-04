package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieUpdateStrategyTest {

    private final AgedBrieUpdateStrategy strategy = new AgedBrieUpdateStrategy();

    @Test
    public void increasesQualityBeforeSellIn() {
        Item item = new Item("Aged Brie", 2, 0);
        strategy.update(item);
        assertEquals(1, item.quality);
        assertEquals(1, item.sellIn);
    }

    @Test
    public void increasesQualityTwiceAfterSellIn() {
        Item item = new Item("Aged Brie", 0, 0);
        strategy.update(item);
        assertEquals(2, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void qualityDoesNotExceed50() {
        Item item = new Item("Aged Brie", 2, 50);
        strategy.update(item);
        assertEquals(50, item.quality);
    }
}
