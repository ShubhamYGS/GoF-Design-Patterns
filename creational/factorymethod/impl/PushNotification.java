package factorymethod.impl;

import factorymethod.intf.Notification;

/**
 * Sends push notifications (demo prints to console).
 */
public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending push notification: " + message);
    }
}