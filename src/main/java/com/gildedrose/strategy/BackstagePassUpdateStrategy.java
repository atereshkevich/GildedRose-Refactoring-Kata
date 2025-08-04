package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

/**
 * Update strategy for "Backstage passes":
 * - Quality increases as sellIn approaches:
 *   + by 1 if sellIn > 10
 *   + by 2 if 6 <= sellIn <= 10
 *   + by 3 if 1 <= sellIn <= 5
 * - After concert (sellIn <= 0), quality drops to 0.
 * - Quality never exceeds MAX_QUALITY.
 */
public class BackstagePassUpdateStrategy implements ItemUpdateStrategy {
    private static final int MAX_QUALITY = 50;
    private static final int FIRST_THRESHOLD = 10;
    private static final int SECOND_THRESHOLD = 5;

    @Override
    public void update(Item item) {
        // If not at MAX_QUALITY, calculate how much to increase quality today
        if (item.quality() < MAX_QUALITY) {
            int qualityIncrease = 1;

            // When 10 days or fewer left, increase by an extra 1
            if (item.sellIn() <= FIRST_THRESHOLD) {
                qualityIncrease++;
            }
            // When 5 days or fewer left, increase by yet another 1 (total +3)
            if (item.sellIn() <= SECOND_THRESHOLD) {
                qualityIncrease++;
            }

            increaseQuality(item, qualityIncrease);
        }

        item.decreaseSellIn();

        if (item.isExpired()) {
            item.resetQuality();
        }

    }

    /**
     * Helper: Increase item's quality by specified amount, but never exceed MAX_QUALITY.
     */
    private void increaseQuality(Item item, int amount) {
        int newQuality = Math.min(item.quality() + amount, MAX_QUALITY);
        while (item.quality() < newQuality) {
            item.increaseQuality();
        }
    }
}
