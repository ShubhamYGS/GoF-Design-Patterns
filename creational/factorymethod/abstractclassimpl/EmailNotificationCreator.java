package factorymethod.abstractclassimpl;

import factorymethod.abstractclass.NotificationCreator;
import factorymethod.impl.EmailNotification;
import factorymethod.intf.Notification;

/**
 * Concrete creator that produces an EmailNotification.
 * Client uses this creator when it needs email delivery.
 */
public class EmailNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}