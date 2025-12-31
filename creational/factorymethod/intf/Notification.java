package factorymethod.intf;

/**
 * Simple notification contract used by the Simple Factory example.
 * Implementations (Email/SMS/Push) provide the actual send behavior.
 */
public interface Notification {
    void send(String message);
}