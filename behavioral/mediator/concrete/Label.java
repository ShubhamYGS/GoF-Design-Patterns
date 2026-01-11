package mediator.concrete;

import mediator.abstractclass.UIComponent;
import mediator.intf.UIMediator;

/**
 * Colleague component.
 * Displays status messages (set by the mediator).
 */
public class Label extends UIComponent {
    private String text;

    public Label(UIMediator mediator) {
        super(mediator);
    }

    public void setText(String message) {
        this.text = message;
        System.out.println("Status: " + text);
    }
}