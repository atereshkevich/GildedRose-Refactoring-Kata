package com.gildedrose.strategy;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.ItemType;

import java.util.HashMap;
import java.util.Map;

public class ItemUpdateStrategyFactory {
    private final Map<ItemType, ItemUpdateStrategy> strategies = new HashMap<>();
    private final ItemUpdateStrategy defaultStrategy = new DefaultUpdateStrategy();

    public ItemUpdateStrategyFactory() {
        strategies.put(ItemType.AGED_BRIE, new AgedBrieUpdateStrategy());
        strategies.put(ItemType.BACKSTAGE_PASS, new BackstagePassUpdateStrategy());
    }

    public ItemUpdateStrategy getStrategy(Item item) {
        ItemUpdateStrategy strategy = strategies.get(item.type());
        return strategy != null ? strategy : defaultStrategy;
    }
}
