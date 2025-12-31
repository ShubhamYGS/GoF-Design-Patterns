package factorymethod.impl;

import factorymethod.intf.Notification;

/**
 * Sends notifications via email (demo prints to console).
 * Role: EmailNotification
 */
public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}