package com.gildedrose.components;

import com.gildedrose.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;
import com.gildedrose.strategy.ItemUpdateStrategyFactory;

public class ItemUpdater {
    private final ItemUpdateStrategyFactory factory = new ItemUpdateStrategyFactory();

    public void update(Item item) {
        ItemUpdateStrategy strategy = factory.getStrategy(item);
        strategy.update(item);
    }
}
