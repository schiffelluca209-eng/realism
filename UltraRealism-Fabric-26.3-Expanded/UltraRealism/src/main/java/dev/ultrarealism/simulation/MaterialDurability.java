package dev.ultrarealism.simulation;

/** Material wear utility for tools, machines, and vehicle components. */
public final class MaterialDurability {
    private MaterialDurability() {}

    public static int applyWear(int current, int max, double stress, double resistance) {
        if (max < 1 || current < 0 || current > max) throw new IllegalArgumentException("invalid durability");
        if (!Double.isFinite(stress) || stress < 0) throw new IllegalArgumentException("stress must be >= 0");
        if (!Double.isFinite(resistance) || resistance < 0) throw new IllegalArgumentException("resistance must be >= 0");
        double divisor = 1.0 + resistance;
        int damage = (int) Math.ceil(stress / divisor);
        return Math.max(0, current - damage);
    }

    public static int repair(int current, int max, int repairPoints) {
        if (max < 1 || current < 0 || current > max || repairPoints < 0)
            throw new IllegalArgumentException("invalid repair arguments");
        return Math.min(max, current + repairPoints);
    }
}
