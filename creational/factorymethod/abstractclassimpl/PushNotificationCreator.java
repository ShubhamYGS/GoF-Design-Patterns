package factorymethod.abstractclassimpl;

import factorymethod.abstractclass.NotificationCreator;
import factorymethod.impl.PushNotification;
import factorymethod.intf.Notification;

/**
 * Concrete creator that produces a PushNotification.
 */
public class PushNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}