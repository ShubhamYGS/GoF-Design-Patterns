package abstractfactory.intf;

/**
 * Button GUI component contract used by the Abstract Factory example.
 * Concrete implementations provide platform-specific rendering and behavior.
 */
public interface Button {
    void paint();

    void onClick();
}