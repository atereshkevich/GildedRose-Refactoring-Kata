package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

public class DefaultUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        if (item.quality() > 0) {
            item.decreaseQuality();
        }

        item.decreaseSellIn();

        if (item.isExpired() && item.quality() > 0) {
            item.decreaseQuality();
        }
    }
}
