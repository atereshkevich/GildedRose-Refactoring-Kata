package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

public class AgedBrieUpdateStrategy implements ItemUpdateStrategy {
    private static final int MAX_QUALITY = 50;

    @Override
    public void update(Item item) {
        increaseQualityIfPossible(item);

        item.decreaseSellIn();

        if (item.isExpired()) {
            increaseQualityIfPossible(item);
        }
    }

    private void increaseQualityIfPossible(Item item) {
        if (item.quality() < MAX_QUALITY) {
            item.increaseQuality();
        }
    }
}
