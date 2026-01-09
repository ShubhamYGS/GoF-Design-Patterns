package observer.impl;

import observer.intf.FitnessDataObserver;

/**
 * Concrete Observer.
 * Prints the latest fitness values to the console as soon as they change.
 */
public class LiveActivityDisplay implements FitnessDataObserver {
    @Override
    public void update(FitnessData data) {
        // Read the current state from the subject and show it to the user.
        System.out.println("Live Display → Steps: " + data.getSteps() +
                " | Active Minutes: " + data.getActiveMinutes() +
                " | Calories: " + data.getCalories());
    }
}