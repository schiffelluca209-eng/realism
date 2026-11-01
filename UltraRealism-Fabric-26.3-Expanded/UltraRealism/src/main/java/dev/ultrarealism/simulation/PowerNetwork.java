package dev.ultrarealism.simulation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Simple deterministic power allocation model. Actual cable/block entity,
 * persistence, networking, and UI integration are not included yet.
 */
public final class PowerNetwork {
    public record Consumer(String id, double requestedPower, int priority) {
        public Consumer {
            if (id == null || id.isBlank()) throw new IllegalArgumentException("id required");
            if (!Double.isFinite(requestedPower) || requestedPower < 0)
                throw new IllegalArgumentException("requestedPower must be >= 0");
        }
    }

    public record Allocation(String id, double suppliedPower, double requestedPower) {
        public boolean fullyPowered() { return suppliedPower >= requestedPower; }
    }

    private PowerNetwork() {}

    public static List<Allocation> allocate(double availablePower, List<Consumer> consumers) {
        if (!Double.isFinite(availablePower) || availablePower < 0)
            throw new IllegalArgumentException("availablePower must be >= 0");
        List<Consumer> ordered = new ArrayList<>(consumers);
        ordered.sort(Comparator.comparingInt(Consumer::priority).reversed().thenComparing(Consumer::id));
        List<Allocation> result = new ArrayList<>();
        double remaining = availablePower;
        for (Consumer consumer : ordered) {
            double supplied = Math.min(remaining, consumer.requestedPower());
            result.add(new Allocation(consumer.id(), supplied, consumer.requestedPower()));
            remaining -= supplied;
        }
        return List.copyOf(result);
    }
}
