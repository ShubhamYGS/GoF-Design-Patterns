package nullobject;

import nullobject.impl.NullPreferences;
import nullobject.impl.UserPreferences;
import nullobject.intf.Preferences;

/**
 * Factory/helper that decides which Preferences implementation to return.
 * This hides the choice (real vs null object) from the rest of the code.
 */
public class PreferencesFactory {

    public static Preferences create(boolean hasPreferences) {
        if (hasPreferences) {
            return new UserPreferences(true, "Dark");
        }
        // Null Object: safe default implementation (never returns null)
        return NullPreferences.getInstance();
    }
}
