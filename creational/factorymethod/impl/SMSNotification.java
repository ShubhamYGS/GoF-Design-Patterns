package factorymethod.impl;

import factorymethod.intf.Notification;

/**
 * Sends notifications via SMS (demo prints to console).
 */
public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}