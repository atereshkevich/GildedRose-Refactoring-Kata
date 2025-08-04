package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

public class AgedBrieUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        if (item.quality() < 50) {
            item.increaseQuality();
        }

        item.decreaseSellIn();

        if (item.isExpired() && item.quality() < 50) {
            item.increaseQuality();
        }
    }
}
