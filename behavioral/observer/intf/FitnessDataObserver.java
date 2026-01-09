package observer.intf;

import observer.impl.FitnessData;

/**
 * Observer interface.
 * Implementations get called whenever the Subject (FitnessData) changes.
 */
public interface FitnessDataObserver {
    /**
     * Called by the subject on every state change.
     * Observers can read the latest values from the provided FitnessData object.
     */
    void update(FitnessData data);
}