package nullobject.impl;

import nullobject.intf.Preferences;

/**
 * NullObject in the Null Object pattern.
 * Used when a user has no preferences configured (avoids null checks).
 */
public class NullPreferences implements Preferences {

    // Singleton because all "no preferences" users can share the same instance.
    private static final NullPreferences INSTANCE = new NullPreferences();

    private NullPreferences() {
    }

    public static NullPreferences getInstance() {
        return INSTANCE;
    }

    @Override
    public void displaySettings() {
        System.out.println("No preferences configured.");
    }
}
