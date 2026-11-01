package dev.ultrarealism.simulation;

/** Server-side animal needs model to be connected to a custom Mob/Animal entity. */
public record AnimalNeeds(double hunger, double thirst, double fatigue, double stress) {
    public AnimalNeeds {
        hunger = clamp(hunger);
        thirst = clamp(thirst);
        fatigue = clamp(fatigue);
        stress = clamp(stress);
    }

    public AnimalNeeds tick(double hungerRate, double thirstRate, double fatigueRate, double stressChange) {
        return new AnimalNeeds(hunger + hungerRate, thirst + thirstRate,
                fatigue + fatigueRate, stress + stressChange);
    }

    public AnimalNeeds eat(double foodValue) {
        return new AnimalNeeds(hunger - Math.max(0, foodValue), thirst, fatigue, stress);
    }

    public AnimalNeeds drink(double waterValue) {
        return new AnimalNeeds(hunger, thirst - Math.max(0, waterValue), fatigue, stress);
    }

    public boolean critical() {
        return hunger >= 0.9 || thirst >= 0.9;
    }

    private static double clamp(double v) {
        if (!Double.isFinite(v)) return 0;
        return Math.max(0, Math.min(1, v));
    }
}
