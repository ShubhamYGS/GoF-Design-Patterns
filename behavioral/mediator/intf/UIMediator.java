package mediator.intf;

import mediator.abstractclass.UIComponent;

/**
 * Mediator contract.
 * UI components notify the mediator when they change, and the mediator coordinates the reactions.
 */
public interface UIMediator {
    void componentChanged(UIComponent component);
}