package com.gildedrose.strategy;

/**
 * Configuration class for item update strategies.
 * Registers strategies for specific item types (e.g. "Aged Brie", "Backstage passes...").
 * Returns a registry that maps items to the right update strategy.
 */
public class StrategyConfiguration {
    /**
     * Factory method that sets up the registry with all known strategies.
     * You can extend this to register more strategies as business rules evolve.
     *
     * @return Configured ItemUpdateStrategyRegistry.
     */
    public static ItemUpdateStrategyRegistry configure() {
        ItemUpdateStrategyRegistry registry = new ItemUpdateStrategyRegistry();

        registry.register(item -> "Aged Brie".equals(item.name()), new AgedBrieUpdateStrategy());
        registry.register(item -> "Backstage passes to a TAFKAL80ETC concert".equals(item.name()), new BackstagePassUpdateStrategy());

        // Here is the place to register new strategies as needed, e.g. for "Sulfuras", "Conjured", etc.

        return registry;
    }
}
