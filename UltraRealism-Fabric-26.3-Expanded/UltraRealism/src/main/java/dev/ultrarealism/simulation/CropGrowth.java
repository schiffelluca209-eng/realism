package dev.ultrarealism.simulation;

/** Small deterministic crop model; Minecraft world hooks are a later integration task. */
public final class CropGrowth {
    private final int stage;
    private final int maxStage;
    private final double soilMoisture; // 0..1
    private final double lightFactor;  // 0..1
    private final double temperatureFactor; // 0..1

    public CropGrowth(int stage, int maxStage, double soilMoisture,
                      double lightFactor, double temperatureFactor) {
        if (maxStage < 1 || stage < 0 || stage > maxStage) throw new IllegalArgumentException("invalid stage");
        this.stage = stage;
        this.maxStage = maxStage;
        this.soilMoisture = clamp(soilMoisture);
        this.lightFactor = clamp(lightFactor);
        this.temperatureFactor = clamp(temperatureFactor);
    }

    public CropGrowth growOneStep(double fertilizerBonus) {
        double bonus = Math.max(0, Math.min(1, fertilizerBonus));
        double growthScore = soilMoisture * 0.40 + lightFactor * 0.35 + temperatureFactor * 0.25 + bonus;
        int next = growthScore >= 0.55 ? Math.min(maxStage, stage + 1) : stage;
        return new CropGrowth(next, maxStage, soilMoisture, lightFactor, temperatureFactor);
    }

    public boolean isMature() { return stage == maxStage; }
    public int stage() { return stage; }
    public int maxStage() { return maxStage; }

    private static double clamp(double v) {
        if (!Double.isFinite(v)) return 0;
        return Math.max(0, Math.min(1, v));
    }
}
