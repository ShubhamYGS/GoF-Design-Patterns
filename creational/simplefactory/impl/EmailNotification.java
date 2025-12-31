package simplefactory.impl;

import simplefactory.intf.Notification;

/**
 * Sends notifications via email (demo prints to console).
 */
public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}