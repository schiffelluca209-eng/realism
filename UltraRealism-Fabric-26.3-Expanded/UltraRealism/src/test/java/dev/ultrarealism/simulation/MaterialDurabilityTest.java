package dev.ultrarealism.simulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaterialDurabilityTest {
    @Test void wearRespectsResistanceAndZero() {
        assertEquals(8, MaterialDurability.applyWear(10, 10, 2, 0));
        assertEquals(9, MaterialDurability.applyWear(10, 10, 2, 1));
        assertEquals(0, MaterialDurability.applyWear(1, 10, 100, 0));
    }

    @Test void repairCannotExceedMaximum() {
        assertEquals(10, MaterialDurability.repair(8, 10, 100));
    }
}
