package dev.ultrarealism.simulation;

import java.util.List;

/** Central, code-level list of planned systems used for startup sanity checks. */
public final class SimulationCatalog {
    public static final List<String> MODULES = List.of(
        "food_freshness", "crop_growth", "material_durability",
        "animal_needs", "power_network"
    );

    private SimulationCatalog() {}

    public static void validate() {
        if (MODULES.isEmpty()) throw new IllegalStateException("No simulation modules configured");
    }
}
