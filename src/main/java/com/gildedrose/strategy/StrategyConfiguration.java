package com.gildedrose.strategy;

public class StrategyConfiguration {
    public static ItemUpdateStrategyRegistry configure() {
        ItemUpdateStrategyRegistry registry = new ItemUpdateStrategyRegistry();

        registry.register(item -> "Aged Brie".equals(item.name()), new AgedBrieUpdateStrategy());
        registry.register(item -> "Backstage passes to a TAFKAL80ETC concert".equals(item.name()), new BackstagePassUpdateStrategy());

        return registry;
    }
}
