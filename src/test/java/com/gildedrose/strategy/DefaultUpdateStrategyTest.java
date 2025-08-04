package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultUpdateStrategyTest {

    private final DefaultUpdateStrategy strategy = new DefaultUpdateStrategy();

    @Test
    public void decreasesQualityAndSellIn() {
        Item item = new Item("foo", 10, 20);
        strategy.update(item);
        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
    }

    @Test
    public void qualityDegradesTwiceAfterSellIn() {
        Item item = new Item("foo", 0, 20);
        strategy.update(item);
        assertEquals(-1, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    public void qualityDoesNotGoNegative() {
        Item item = new Item("foo", 5, 0);
        strategy.update(item);
        assertEquals(0, item.quality);
    }
}
