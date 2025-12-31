package abstractfactory;

import abstractfactory.factoryintf.GUIFactory;
import abstractfactory.intf.Button;
import abstractfactory.intf.Checkbox;

/**
 * Application uses an abstract GUIFactory to obtain a family of
 * related GUI components without depending on their concrete classes.
 * This lets the same Application run with different look-and-feel.
 */
public class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.paint();
        checkbox.paint();
    }
}