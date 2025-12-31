package abstractfactory;

import abstractfactory.factoryimpl.MacOSFactory;
import abstractfactory.factoryimpl.WindowsFactory;
import abstractfactory.factoryintf.GUIFactory;

/**
 * Demo client that chooses a concrete GUIFactory based on the OS
 * and runs the application with that look-and-feel.
 */
public class Client {
    public static void main(String[] args) {
        String os = System.getProperty("os.name");
        GUIFactory factory;

        if (os.contains("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacOSFactory();
        }

        Application app = new Application(factory);
        app.renderUI();
    }
}