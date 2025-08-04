package com.gildedrose.domain;

import lombok.Data;

@Data
public class Item {
    private String name;
    private int sellIn;
    private int quality;
    private ItemType type;

    public Item(String name, int sellIn, int quality, ItemType type) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.type = type;
    }

    public Item(String name, int sellIn, int quality) {
        this(name, sellIn, quality, ItemType.fromName(name));
    }

    public void decreaseSellIn() {
        this.sellIn -= 1;
    }

    public void increaseQuality() {
        this.quality += 1;
    }

    public void decreaseQuality() {
        this.quality -= 1;
    }

    public boolean isExpired() {
        return sellIn < 0;
    }

    public void resetQuality() {
        this.quality = 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
