package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

public class AgedBrieUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        if (item.quality() < 50) {
            item.quality(item.quality() + 1);
        }

        item.sellIn(item.sellIn() - 1);

        if (item.sellIn() < 0 && item.quality() < 50) {
            item.quality(item.quality() + 1);
        }
    }
}
