package command.devices;

/**
 * Receiver in the Command pattern.
 * Knows how to perform the real action (turning the light on/off).
 */
public class Light {
    public void on() {
        System.out.println("Light turned ON");
    }

    public void off() {
        System.out.println("Light turned OFF");
    }
}