package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

public class DefaultUpdateStrategy implements ItemUpdateStrategy {
    private static final int MIN_QUALITY = 0;

    @Override
    public void update(Item item) {
        decreaseQualityIfPossible(item);

        item.decreaseSellIn();

        if (item.isExpired()) {
            decreaseQualityIfPossible(item);
        }
    }

    private void decreaseQualityIfPossible(Item item) {
        if (item.quality() > MIN_QUALITY) {
            item.decreaseQuality();
        }
    }
}
