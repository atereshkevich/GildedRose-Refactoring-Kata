package com.gildedrose.strategy;

import com.gildedrose.domain.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Registry for item update strategies.
 * This class maps predicates (conditions on an Item) to a corresponding update strategy.
 * When asked for a strategy, it finds the first registered predicate that matches the item and returns its strategy.
 * If none match, a default strategy is used.
 */
public class ItemUpdateStrategyRegistry {
    // Stores mapping: predicate (matcher) -> update strategy.
    private final Map<Predicate<Item>, ItemUpdateStrategy> registry = new HashMap<>();
    // Default strategy to use if no predicate matches.
    private final ItemUpdateStrategy defaultStrategy = new DefaultUpdateStrategy();

    public void register(Predicate<Item> predicate, ItemUpdateStrategy strategy) {
        registry.put(predicate, strategy);
    }

    /**
     * Find and return the appropriate update strategy for a given item.
     * - The first matching predicate's strategy is returned.
     * - If none match, returns the default strategy.
     *
     * @param item The item to find a strategy for.
     * @return The strategy to update the item.
     */
    public ItemUpdateStrategy getStrategy(Item item) {
        for (Map.Entry<Predicate<Item>, ItemUpdateStrategy> entry : registry.entrySet()) {
            if (entry.getKey().test(item)) {
                return entry.getValue();
            }
        }
        return defaultStrategy;
    }
}
