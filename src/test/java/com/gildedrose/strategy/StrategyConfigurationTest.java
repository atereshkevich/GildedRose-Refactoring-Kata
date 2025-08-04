package com.gildedrose.strategy;

import com.gildedrose.domain.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StrategyConfigurationTest {
    @Test
    void testAgedBrieStrategy() {
        ItemUpdateStrategyRegistry registry = StrategyConfiguration.configure();
        Item item = new Item("Aged Brie", 10, 10);

        ItemUpdateStrategy strategy = registry.getStrategy(item);

        assertTrue(strategy instanceof AgedBrieUpdateStrategy, "Should return AgedBrieUpdateStrategy");
    }

    @Test
    void testBackstagePassStrategy() {
        ItemUpdateStrategyRegistry registry = StrategyConfiguration.configure();
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10);

        ItemUpdateStrategy strategy = registry.getStrategy(item);

        assertTrue(strategy instanceof BackstagePassUpdateStrategy, "Should return BackstagePassUpdateStrategy");
    }

    @Test
    void testDefaultStrategy() {
        ItemUpdateStrategyRegistry registry = StrategyConfiguration.configure();
        Item item = new Item("Elixir of the Mongoose", 5, 7);

        ItemUpdateStrategy strategy = registry.getStrategy(item);

        assertTrue(strategy instanceof DefaultUpdateStrategy, "Should return DefaultUpdateStrategy for unknown items");
    }
}
