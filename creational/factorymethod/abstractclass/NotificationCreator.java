package factorymethod.abstractclass;

import factorymethod.intf.Notification;

/**
 * Abstract creator in Factory Method pattern.
 * Subclasses decide which concrete Notification to instantiate by
 * implementing createNotification().
 * <p>
 * The send() method demonstrates how the creator can provide
 * common logic (pre/post steps) while deferring object creation.
 */
public abstract class NotificationCreator {
    public abstract Notification createNotification();

    public void send(String message) {
        Notification notification = createNotification();
        System.out.println("Custom logic before sending notification");
        notification.send(message);
    }
}