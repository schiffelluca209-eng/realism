package dev.ultrarealism;

import dev.ultrarealism.simulation.SimulationCatalog;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Fabric entry point. Game registries and entity/client render integration
 * are intentionally separate modules to keep the project maintainable.
 */
public final class UltraRealism implements ModInitializer {
    public static final String MOD_ID = "ultrarealism";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        SimulationCatalog.validate();
        LOGGER.info("Ultra Realism {} initialized; simulation catalog loaded.", "0.2.0");
        LOGGER.warn("This build is a development foundation. Check README.md for incomplete in-game integrations.");
    }
}
