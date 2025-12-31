package factorymethod.abstractclassimpl;

import factorymethod.abstractclass.NotificationCreator;
import factorymethod.impl.SMSNotification;
import factorymethod.intf.Notification;

/**
 * Concrete creator that produces an SMSNotification.
 */
public class SMSNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}