package factorymethod;

import factorymethod.abstractclass.NotificationCreator;
import factorymethod.abstractclassimpl.EmailNotificationCreator;
import factorymethod.abstractclassimpl.PushNotificationCreator;
import factorymethod.abstractclassimpl.SMSNotificationCreator;

/**
 * Demo client showing how Factory Method lets subclasses decide
 * which Notification implementation to create. Client code calls
 * the creator's send() method and doesn't need to know the concrete
 * notification type.
 */
public class Client {
    public static void main(String[] args) {
        NotificationCreator creator;

        // Send Email
        creator = new EmailNotificationCreator();
        creator.send("Welcome to our platform!");

        // Send SMS
        creator = new SMSNotificationCreator();
        creator.send("Your OTP is 123456");

        // Send Push Notification
        creator = new PushNotificationCreator();
        creator.send("You have a new follower!");
    }
}
