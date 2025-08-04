package com.gildedrose;

import com.gildedrose.components.ItemUpdater;
import com.gildedrose.domain.Item;
import com.gildedrose.strategy.ItemUpdateStrategyRegistry;
import lombok.Getter;

@Getter
public class GildedRose {
    private final Item[] items;
    private final ItemUpdater updater;

    public GildedRose(Item[] items, ItemUpdateStrategyRegistry registry) {
        this.items = items;
        this.updater = new ItemUpdater(registry);
    }

    public void updateQuality() {
        for (Item item : items) {
            updater.update(item);
        }
    }
}
