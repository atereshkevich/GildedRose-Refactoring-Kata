package com.gildedrose.strategy;

import com.gildedrose.domain.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassUpdateStrategyTest {

    private final BackstagePassUpdateStrategy strategy = new BackstagePassUpdateStrategy();

    @Test
    public void increasesQualityBy1Above10Days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        strategy.update(item);
        assertEquals(21, item.quality());
    }

    @Test
    public void increasesQualityBy2When10DaysLeft() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        strategy.update(item);
        assertEquals(22, item.quality());
    }

    @Test
    public void increasesQualityBy3When5DaysLeft() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        strategy.update(item);
        assertEquals(23, item.quality());
    }

    @Test
    public void dropsQualityToZeroAfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        strategy.update(item);
        assertEquals(0, item.quality());
    }

    @Test
    public void doesNotExceed50() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        strategy.update(item);
        assertEquals(50, item.quality());
    }
}
