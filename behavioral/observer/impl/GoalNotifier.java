package observer.impl;

import observer.intf.FitnessDataObserver;

/**
 * Concrete Observer.
 * Watches for a step goal and sends a one-time notification when the goal is reached.
 */
public class GoalNotifier implements FitnessDataObserver {
    private final int stepGoal = 10000;

    // Used to avoid sending the same "goal reached" message on every update.
    private boolean goalReached = false;

    @Override
    public void update(FitnessData data) {
        if (data.getSteps() >= stepGoal && !goalReached) {
            System.out.println("Notifier → 🎉 Goal Reached! You've hit " + stepGoal + " steps!");
            goalReached = true;
        }
    }

    /**
     * Allows notifying again (e.g., a new day starts).
     */
    public void reset() {
        goalReached = false;
    }
}