package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

/**
 * Update strategy for "Aged Brie" items:
 * - Quality increases by 1 each day until it reaches MAX_QUALITY.
 * - After expiration (sellIn < 0), quality increases by an additional 1 (total +2 per day), still capped at MAX_QUALITY.
 */
public class AgedBrieUpdateStrategy implements ItemUpdateStrategy {
    private static final int MAX_QUALITY = 50;

    @Override
    public void update(Item item) {
        increaseQualityIfPossible(item);

        item.decreaseSellIn();

        // If item is expired (sellIn < 0), increase quality again (still maxed at MAX_QUALITY)
        if (item.isExpired()) {
            increaseQualityIfPossible(item);
        }
    }

    /**
     * Helper: Increases item's quality by 1, but never exceeds MAX_QUALITY.
     */
    private void increaseQualityIfPossible(Item item) {
        if (item.quality() < MAX_QUALITY) {
            item.increaseQuality();
        }
    }
}
