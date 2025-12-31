package abstractfactory.factoryimpl;

import abstractfactory.factoryintf.GUIFactory;
import abstractfactory.impl.MacOSButton;
import abstractfactory.impl.MacOSCheckbox;
import abstractfactory.intf.Button;
import abstractfactory.intf.Checkbox;

/**
 * Concrete factory for macOS platform components.
 * Returns macOS-specific Button and Checkbox implementations.
 */
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}