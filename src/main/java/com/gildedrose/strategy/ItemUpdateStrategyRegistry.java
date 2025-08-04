package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class ItemUpdateStrategyRegistry {
    private final Map<Predicate<Item>, ItemUpdateStrategy> registry = new HashMap<>();
    private final ItemUpdateStrategy defaultStrategy = new DefaultUpdateStrategy();

    public void register(Predicate<Item> predicate, ItemUpdateStrategy strategy) {
        registry.put(predicate, strategy);
    }

    public ItemUpdateStrategy getStrategy(Item item) {
        for (Map.Entry<Predicate<Item>, ItemUpdateStrategy> entry : registry.entrySet()) {
            if (entry.getKey().test(item)) {
                return entry.getValue();
            }
        }
        return defaultStrategy;
    }
}
