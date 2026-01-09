package observer.intf;

/**
 * Subject interface.
 * A subject lets observers subscribe/unsubscribe and notifies them when its state changes.
 */
public interface FitnessDataSubject {
    void registerObserver(FitnessDataObserver observer);

    void removeObserver(FitnessDataObserver observer);

    // Typically called internally after the subject's state changes.
    void notifyObservers();
}