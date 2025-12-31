package abstractfactory.intf;

/**
 * Checkbox GUI component contract used by the Abstract Factory example.
 * Concrete implementations provide platform-specific rendering and behavior.
 */
public interface Checkbox {
    void paint();

    void onSelect();
}