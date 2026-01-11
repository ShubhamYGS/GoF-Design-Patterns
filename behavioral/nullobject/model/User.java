package nullobject.model;

import nullobject.intf.Preferences;

/**
 * Context class that uses Preferences.
 * Because of the Null Object pattern, preferences is always safe to call.
 */
public class User {

    private final String name;
    private final Preferences preferences;

    public User(String name, Preferences preferences) {
        this.name = name;
        this.preferences = preferences;
    }

    public void displayUserInfo() {
        System.out.println("User: " + name);
        preferences.displaySettings(); // No if-else / null check needed
    }
}
