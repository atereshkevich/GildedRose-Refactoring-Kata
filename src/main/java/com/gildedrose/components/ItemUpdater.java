package com.gildedrose.components;

import com.gildedrose.domain.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;
import com.gildedrose.strategy.ItemUpdateStrategyRegistry;

public class ItemUpdater {
    private final ItemUpdateStrategyRegistry registry;

    public ItemUpdater(ItemUpdateStrategyRegistry registry) {
        this.registry = registry;
    }

    public void update(Item item) {
        ItemUpdateStrategy strategy = registry.getStrategy(item);
        strategy.update(item);
    }
}
