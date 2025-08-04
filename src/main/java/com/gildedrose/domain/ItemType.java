package com.gildedrose.domain;

public enum ItemType {
    AGED_BRIE,
    BACKSTAGE_PASS,
    DEFAULT;

    public static ItemType fromName(String name) {
        if ("Aged Brie".equals(name)) return AGED_BRIE;
        if ("Backstage passes to a TAFKAL80ETC concert".equals(name)) return BACKSTAGE_PASS;
        return DEFAULT;
    }
}
