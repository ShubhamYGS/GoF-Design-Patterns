package simplefactory;

import simplefactory.factory.NotificationFactory;
import simplefactory.intf.Notification;

/**
 * Demo client for the Simple Factory example.
 * Requests different Notification objects from the factory and sends messages.
 */
public class Client {
    public static void main(String[] args) {
        Notification emailNotification = NotificationFactory.createNotification("email");
        emailNotification.send("Hello via Email!");

        Notification smsNotification = NotificationFactory.createNotification("sms");
        smsNotification.send("Hello via SMS!");

        Notification pushNotification = NotificationFactory.createNotification("push");
        pushNotification.send("Hello via Push Notification!");
    }
}
