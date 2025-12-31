package simplefactory.factory;

import simplefactory.impl.EmailNotification;
import simplefactory.impl.PushNotification;
import simplefactory.impl.SMSNotification;
import simplefactory.intf.Notification;

/**
 * Simple Factory that creates Notification instances based on a channel string.
 * Centralizes object creation so client code doesn't need to know concrete classes.
 */
public class NotificationFactory {
    public static Notification createNotification(String channel) {
        switch (channel.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification channel: " + channel);
        }
    }
}
