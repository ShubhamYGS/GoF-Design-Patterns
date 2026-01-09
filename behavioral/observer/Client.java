package observer;

import observer.impl.FitnessData;
import observer.impl.GoalNotifier;
import observer.impl.LiveActivityDisplay;
import observer.impl.ProgressLogger;

/**
 * Demo client for the Observer pattern.
 * Wires a Subject (FitnessData) with multiple Observers (display/logger/notifier).
 */
public class Client {
    public static void main(String[] args) {
        // Subject: holds the latest fitness state and notifies observers on changes.
        FitnessData fitnessData = new FitnessData();

        // Observers: react to subject updates in different ways.
        LiveActivityDisplay display = new LiveActivityDisplay();
        ProgressLogger logger = new ProgressLogger();
        GoalNotifier notifier = new GoalNotifier();

        // Register observers
        fitnessData.registerObserver(display);
        fitnessData.registerObserver(logger);
        fitnessData.registerObserver(notifier);

        // Simulate updates
        fitnessData.newFitnessDataPushed(500, 5, 20);
        fitnessData.newFitnessDataPushed(9800, 85, 350);
        fitnessData.newFitnessDataPushed(10100, 90, 380); // Goal should trigger

        // Daily reset
        notifier.reset();
        fitnessData.dailyReset();
    }
}