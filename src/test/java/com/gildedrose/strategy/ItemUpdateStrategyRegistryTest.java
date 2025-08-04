package com.gildedrose.strategy;

import com.gildedrose.domain.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemUpdateStrategyRegistryTest {
    private static class DummyStrategy1 implements ItemUpdateStrategy {
        @Override
        public void update(Item item) {

        }
    }
    private static class DummyStrategy2 implements ItemUpdateStrategy {
        @Override
        public void update(Item item) {

        }
    }

    @Test
    public void returnsRegisteredStrategy() {
        ItemUpdateStrategyRegistry registry = new ItemUpdateStrategyRegistry();
        ItemUpdateStrategy strategy1 = new DummyStrategy1();
        Item item1 = new Item("A", 0, 0);

        registry.register(i -> "A".equals(i.name()), strategy1);

        assertSame(strategy1, registry.getStrategy(item1));
    }

    @Test
    public void returnsFirstMatchingStrategy() {
        ItemUpdateStrategyRegistry registry = new ItemUpdateStrategyRegistry();
        ItemUpdateStrategy strategy1 = new DummyStrategy1();
        ItemUpdateStrategy strategy2 = new DummyStrategy2();
        Item item = new Item("X", 0, 0);

        registry.register(i -> i.name().startsWith("X"), strategy1);
        registry.register(i -> i.name().endsWith("X"), strategy2);

        assertSame(strategy1, registry.getStrategy(item));
    }

    @Test
    public void returnsDefaultStrategyIfNoMatch() {
        ItemUpdateStrategyRegistry registry = new ItemUpdateStrategyRegistry();
        Item item = new Item("Unregistered", 1, 1);

        ItemUpdateStrategy strategy = registry.getStrategy(item);

        assertTrue(strategy instanceof DefaultUpdateStrategy);
    }
}
