package nullobject.impl;

import nullobject.intf.Preferences;

/**
 * RealObject in the Null Object pattern.
 * Represents actual saved user preferences.
 */
public class UserPreferences implements Preferences {

    private final boolean emailNotifications;
    private final String theme;

    public UserPreferences(boolean emailNotifications, String theme) {
        this.emailNotifications = emailNotifications;
        this.theme = theme;
    }

    @Override
    public void displaySettings() {
        System.out.println("Email Notifications: " + emailNotifications);
        System.out.println("Theme: " + theme);
    }
}
