package bridge.intf;

/**
 * Implementor interface in the Bridge pattern.
 * Provides low-level rendering operations (different backends can implement this).
 */
public interface Renderer {
    void renderCircle(float radius);

    void renderRectangle(float width, float height);
}