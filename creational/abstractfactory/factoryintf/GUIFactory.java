package abstractfactory.factoryintf;

import abstractfactory.intf.Button;
import abstractfactory.intf.Checkbox;

/**
 * Abstract factory contract producing a family of related GUI components
 * (buttons and checkboxes). Implementations return platform-specific types.
 */
public interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}