package mediator.concrete;

import mediator.abstractclass.UIComponent;
import mediator.intf.UIMediator;

/**
 * Colleague component.
 * Delegates the "login" action to the mediator when clicked.
 */
public class Button extends UIComponent {
    private boolean enabled = false;

    public Button(UIMediator mediator) {
        super(mediator);
    }

    public void click() {
        if (enabled) {
            System.out.println("Login Button clicked!");
            notifyMediator(); // Mediator decides what happens on click
        } else {
            System.out.println("Login Button is disabled.");
        }
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
        System.out.println("Login Button is now " + (enabled ? "ENABLED" : "DISABLED"));
    }
}