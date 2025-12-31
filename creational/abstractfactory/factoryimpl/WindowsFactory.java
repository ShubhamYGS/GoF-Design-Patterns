package abstractfactory.factoryimpl;

import abstractfactory.factoryintf.GUIFactory;
import abstractfactory.impl.WindowsButton;
import abstractfactory.impl.WindowsCheckbox;
import abstractfactory.intf.Button;
import abstractfactory.intf.Checkbox;

/**
 * Concrete factory for Windows platform components.
 * Returns Windows-specific Button and Checkbox implementations.
 */
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}