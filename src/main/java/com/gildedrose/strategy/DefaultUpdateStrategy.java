package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

/**
 * Default update strategy for regular items:
 * - Quality decreases by 1 per day, not below MIN_QUALITY.
 * - After expiration (sellIn < 0), degrades twice as fast (-2 per day).
 */
public class DefaultUpdateStrategy implements ItemUpdateStrategy {
    private static final int MIN_QUALITY = 0;

    @Override
    public void update(Item item) {
        decreaseQualityIfPossible(item);

        item.decreaseSellIn();

        // After expiration (sellIn < 0), degrade quality again (total -2 per day), never below MIN_QUALITY
        if (item.isExpired()) {
            decreaseQualityIfPossible(item);
        }
    }

    /**
     * Helper: Decrease item's quality by 1, but never below MIN_QUALITY.
     */
    private void decreaseQualityIfPossible(Item item) {
        if (item.quality() > MIN_QUALITY) {
            item.decreaseQuality();
        }
    }
}
