package dev.ultrarealism.simulation;

/**
 * Deterministic food freshness model. A Minecraft server tick integration
 * should call advance() at a throttled interval and persist ageTicks.
 */
public final class FoodFreshness {
    public enum State { FRESH, AGING, SPOILED }

    private final long shelfLifeTicks;
    private final long ageTicks;

    public FoodFreshness(long shelfLifeTicks, long ageTicks) {
        if (shelfLifeTicks < 1) throw new IllegalArgumentException("shelfLifeTicks must be positive");
        if (ageTicks < 0) throw new IllegalArgumentException("ageTicks cannot be negative");
        this.shelfLifeTicks = shelfLifeTicks;
        this.ageTicks = ageTicks;
    }

    public FoodFreshness advance(long ticks, double preservationMultiplier) {
        if (ticks < 0) throw new IllegalArgumentException("ticks cannot be negative");
        if (!Double.isFinite(preservationMultiplier) || preservationMultiplier < 0)
            throw new IllegalArgumentException("preservationMultiplier must be finite and >= 0");
        long added = Math.round(ticks * preservationMultiplier);
        long nextAge = ageTicks > Long.MAX_VALUE - added ? Long.MAX_VALUE : ageTicks + added;
        return new FoodFreshness(shelfLifeTicks, nextAge);
    }

    public State state() {
        if (ageTicks >= shelfLifeTicks) return State.SPOILED;
        if (ageTicks >= shelfLifeTicks * 0.65) return State.AGING;
        return State.FRESH;
    }

    public double remainingFraction() {
        return Math.max(0.0, 1.0 - (double) ageTicks / shelfLifeTicks);
    }

    public long ageTicks() { return ageTicks; }
    public long shelfLifeTicks() { return shelfLifeTicks; }
}
