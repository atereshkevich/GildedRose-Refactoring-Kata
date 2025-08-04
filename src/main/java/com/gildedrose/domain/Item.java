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

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
