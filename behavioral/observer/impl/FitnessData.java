package observer.impl;

import observer.intf.FitnessDataObserver;
import observer.intf.FitnessDataSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject in the Observer pattern.
 * Stores the latest fitness state and notifies registered observers whenever it changes.
 */
public class FitnessData implements FitnessDataSubject {
    private int steps;
    private int activeMinutes;
    private int calories;

    // All observers currently listening to fitness updates.
    private final List<FitnessDataObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(FitnessDataObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(FitnessDataObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        // "Pull" model: we pass the subject so observers can read what they need via getters.
        for (FitnessDataObserver observer : observers) {
            observer.update(this);
        }
    }

    /**
     * Updates the internal state and immediately notifies all observers.
     */
    public void newFitnessDataPushed(int steps, int activeMinutes, int calories) {
        this.steps = steps;
        this.activeMinutes = activeMinutes;
        this.calories = calories;

        System.out.println("\nFitnessData: New data received – Steps: " + steps +
                ", Active Minutes: " + activeMinutes + ", Calories: " + calories);

        notifyObservers();
    }

    /**
     * Resets the daily stats and notifies observers (e.g., dashboards can refresh).
     */
    public void dailyReset() {
        this.steps = 0;
        this.activeMinutes = 0;
        this.calories = 0;

        System.out.println("\nFitnessData: Daily reset performed.");
        notifyObservers();
    }

    // Current state (read by observers)
    public int getSteps() {
        return steps;
    }

    public int getActiveMinutes() {
        return activeMinutes;
    }

    public int getCalories() {
        return calories;
    }
}