package com.gildedrose.strategy;

import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemUpdateStrategyFactory {
    private final Map<String, ItemUpdateStrategy> strategies = new HashMap<>();
    private final ItemUpdateStrategy defaultStrategy = new DefaultUpdateStrategy();

    public ItemUpdateStrategyFactory() {
        strategies.put("Aged Brie", new AgedBrieUpdateStrategy());
        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdateStrategy());
    }

    public ItemUpdateStrategy getStrategy(Item item) {
        ItemUpdateStrategy strategy = strategies.get(item.name);
        return strategy != null ? strategy : defaultStrategy;
    }
}
