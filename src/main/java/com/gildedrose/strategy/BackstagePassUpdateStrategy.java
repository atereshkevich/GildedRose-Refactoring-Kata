package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

public class BackstagePassUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        if (item.quality() < 50) item.quality(item.quality() + 1);

        if (item.sellIn() <= 10 && item.quality() < 50) item.quality(item.quality() + 1);
        if (item.sellIn() <= 5 && item.quality() < 50) item.quality(item.quality() + 1);

        item.sellIn(item.sellIn() - 1);

        if (item.sellIn() < 0) {
            item.quality(0);
        }
    }
}
