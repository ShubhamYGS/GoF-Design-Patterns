package observer.impl;

import observer.intf.FitnessDataObserver;

/**
 * Concrete Observer.
 * Pretends to persist fitness updates (e.g., database/file) whenever the subject changes.
 */
public class ProgressLogger implements FitnessDataObserver {
    @Override
    public void update(FitnessData data) {
        System.out.println("Logger → Saving to DB: Steps=" + data.getSteps() +
                ", ActiveMinutes=" + data.getActiveMinutes() +
                ", Calories=" + data.getCalories());
        // In a real app this would write to storage instead of printing.
    }
}