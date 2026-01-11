package mediator.concrete;

import mediator.abstractclass.UIComponent;
import mediator.intf.UIMediator;

/**
 * Colleague component.
 * Updates its own text and informs the mediator so it can update other components.
 */
public class TextField extends UIComponent {
    private String text = "";

    public TextField(UIMediator mediator) {
        super(mediator);
    }

    public void setText(String newText) {
        this.text = newText;
        System.out.println("TextField updated: " + newText);

        // Notify the mediator (e.g., it may enable/disable the login button).
        notifyMediator();
    }

    public String getText() {
        return text;
    }
}