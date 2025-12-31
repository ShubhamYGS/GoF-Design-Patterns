package simplefactory;

import simplefactory.intf.Notification;

/**
 * Demo client for the Simple Factory example.
 * Requests different Notification objects from the factory and sends messages.
 */
public class Client {
    public static void main(String[] args) {
        Notification emailNotification = simplefactory.factory.NotificationFactory.createNotification("email");
        emailNotification.send("Hello via Email!");

        Notification smsNotification = simplefactory.factory.NotificationFactory.createNotification("sms");
        smsNotification.send("Hello via SMS!");

        Notification pushNotification = simplefactory.factory.NotificationFactory.createNotification("push");
        pushNotification.send("Hello via Push Notification!");
    }
}
