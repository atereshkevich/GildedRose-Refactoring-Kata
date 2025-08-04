package com.gildedrose;

import com.gildedrose.domain.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void updatesAllItemsCorrectly() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 1, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 45),
            new Item("foo", 3, 6)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(1, items[0].quality()); // aged brie
        assertEquals(47, items[1].quality()); // backstage
        assertEquals(5, items[2].quality());  // default
    }
}
