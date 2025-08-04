package com.gildedrose.strategy;

import com.gildedrose.domain.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassUpdateStrategyTest {

    private final BackstagePassUpdateStrategy strategy = new BackstagePassUpdateStrategy();

    @Test
    public void increasesQualityBy1Above10Days() {
        // If sellIn > 10, quality increases by 1
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        strategy.update(item);
        assertEquals(21, item.quality());
    }

    @Test
    public void increasesQualityBy2When10DaysLeft() {
        // If sellIn is 10 or less, quality increases by 2
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        strategy.update(item);
        assertEquals(22, item.quality());
    }

    @Test
    public void increasesQualityBy3When5DaysLeft() {
        // If sellIn is 5 or less, quality increases by 3
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        strategy.update(item);
        assertEquals(23, item.quality());
    }

    @Test
    public void dropsQualityToZeroAfterConcert() {
        // After concert (sellIn <= 0), quality drops to 0
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        strategy.update(item);
        assertEquals(0, item.quality());
    }

    @Test
    public void doesNotExceed50() {
        // Quality cannot exceed 50
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        strategy.update(item);
        assertEquals(50, item.quality());
    }

    @Test
    public void qualityDoesNotExceed50WhenIncrementWouldOverflowBy2() {
        // Edge case: when increase would go over 50 (should cap at 50)
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        strategy.update(item);
        assertEquals(50, item.quality());
    }

    @Test
    public void qualityDoesNotExceed50WhenIncrementWouldOverflowBy3() {
        // Edge case: when increase would go over 50 (should cap at 50)
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);
        strategy.update(item);
        assertEquals(50, item.quality());
    }

    @Test
    public void sellInDecreasesEveryDay() {
        // sellIn always decreases by 1 after update
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20);
        strategy.update(item);
        assertEquals(0, item.sellIn());
    }
}
