package mediator.abstractclass;

import mediator.intf.UIMediator;

/**
 * Base class for UI components ("colleagues").
 * Instead of calling other components directly, they notify the mediator.
 */
public abstract class UIComponent {
    protected UIMediator mediator;

    public UIComponent(UIMediator mediator) {
        this.mediator = mediator;
    }

    /**
     * Tell the mediator that something changed in this component.
     */
    public void notifyMediator() {
        mediator.componentChanged(this);
    }
}