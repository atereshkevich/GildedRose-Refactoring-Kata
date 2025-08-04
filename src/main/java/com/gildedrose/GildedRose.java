package com.gildedrose;

import com.gildedrose.components.ItemUpdater;

public class GildedRose {
    private final Item[] items;
    private final ItemUpdater updater = new ItemUpdater();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updater.update(item);
        }
    }

    public Item[] getItems() {
        return items;
    }
}
