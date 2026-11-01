package dev.ultrarealism.simulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CropGrowthTest {
    @Test void goodConditionsAdvanceStage() {
        CropGrowth crop = new CropGrowth(1, 7, 1, 1, 1);
        assertEquals(2, crop.growOneStep(0).stage());
    }

    @Test void poorConditionsDoNotAdvance() {
        CropGrowth crop = new CropGrowth(1, 7, 0, 0, 0);
        assertEquals(1, crop.growOneStep(0).stage());
    }
}
