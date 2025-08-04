package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

public class BackstagePassUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        if (item.quality() < 50) {
            item.increaseQuality();
        }

        if (item.sellIn() <= 10 && item.quality() < 50) {
            item.increaseQuality();
        }
        if (item.sellIn() <= 5 && item.quality() < 50) {
            item.increaseQuality();
        }

        item.decreaseSellIn();

        if (item.isExpired()) {
            item.resetQuality();
        }
    }
}
