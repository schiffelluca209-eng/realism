package dev.ultrarealism.simulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalNeedsTest {
    @Test void needsStayInRange() {
        AnimalNeeds needs = new AnimalNeeds(0.8, 0.4, 0.2, 0.1).tick(0.5, 0, 0, 0);
        assertEquals(1.0, needs.hunger());
        assertTrue(needs.critical());
    }

    @Test void eatingReducesHunger() {
        assertEquals(0.3, new AnimalNeeds(0.7, 0.2, 0, 0).eat(0.4).hunger(), 1e-9);
    }
}
