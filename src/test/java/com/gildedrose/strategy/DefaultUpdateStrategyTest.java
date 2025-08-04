package com.gildedrose.strategy;

import com.gildedrose.domain.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultUpdateStrategyTest {

    private final DefaultUpdateStrategy strategy = new DefaultUpdateStrategy();

    @Test
    public void decreasesQualityAndSellIn() {
        // Quality and sellIn both decrease by 1 if not expired
        Item item = new Item("foo", 10, 20);
        strategy.update(item);
        assertEquals(9, item.sellIn());
        assertEquals(19, item.quality());
    }

    @Test
    public void qualityDegradesTwiceAfterSellIn() {
        // After sellIn date, quality degrades by 2 (per update)
        Item item = new Item("foo", 0, 20);
        strategy.update(item);
        assertEquals(-1, item.sellIn());
        assertEquals(18, item.quality());
    }

    @Test
    public void qualityDoesNotGoNegative() {
        // Quality never goes below zero, even after expiration
        Item item = new Item("foo", 5, 0);
        strategy.update(item);
        assertEquals(0, item.quality());
    }

    @Test
    public void qualityRemainsZeroWhenAlreadyZeroAndExpired() {
        // Edge: if quality is already zero and item expired, stays at zero
        Item item = new Item("foo", 0, 0);
        strategy.update(item);
        assertEquals(-1, item.sellIn());
        assertEquals(0, item.quality());
    }

    @Test
    public void sellInDecreasesBelowZero() {
        // sellIn can become negative, quality won't go below zero
        Item item = new Item("foo", 0, 2);
        strategy.update(item);
        assertEquals(-1, item.sellIn());
        assertEquals(0, item.quality()); // Should decrease by 2, but cap at 0
    }
}
