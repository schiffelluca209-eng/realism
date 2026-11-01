package dev.ultrarealism.simulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FoodFreshnessTest {
    @Test void agesAndSpoils() {
        FoodFreshness food = new FoodFreshness(100, 0).advance(70, 1.0);
        assertEquals(FoodFreshness.State.AGING, food.state());
        assertEquals(FoodFreshness.State.SPOILED, food.advance(40, 1.0).state());
    }

    @Test void preservationSlowsAging() {
        FoodFreshness food = new FoodFreshness(100, 0).advance(100, 0.2);
        assertEquals(FoodFreshness.State.FRESH, food.state());
    }
}
