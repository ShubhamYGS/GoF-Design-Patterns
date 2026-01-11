package nullobject;

import nullobject.model.User;

/**
 * Client/demo for the Null Object pattern.
 * The key idea: users can always call preferences.displaySettings() without null checks.
 */
public class Main {
    public static void main(String[] args) {

        // Factory returns either a real preferences object or a NullPreferences instance.
        User user1 = new User(
                "Alice",
                PreferencesFactory.create(true)
        );

        User user2 = new User(
                "Bob",
                PreferencesFactory.create(false)
        );

        user1.displayUserInfo();
        System.out.println("---------------");
        user2.displayUserInfo();
    }
}
