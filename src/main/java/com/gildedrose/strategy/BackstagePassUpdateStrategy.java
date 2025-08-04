package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

public class BackstagePassUpdateStrategy implements ItemUpdateStrategy {
    private static final int MAX_QUALITY = 50;
    private static final int FIRST_THRESHOLD = 10;
    private static final int SECOND_THRESHOLD = 5;

    @Override
    public void update(Item item) {
        if (item.quality() < MAX_QUALITY) {
            int qualityIncrease = 1;

            if (item.sellIn() <= FIRST_THRESHOLD) {
                qualityIncrease++;
            }
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

    private void increaseQuality(Item item, int amount) {
        int newQuality = Math.min(item.quality() + amount, MAX_QUALITY);
        while (item.quality() < newQuality) {
            item.increaseQuality();
        }
    }
}
