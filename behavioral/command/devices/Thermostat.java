package command.devices;

/**
 * Receiver in the Command pattern.
 * Maintains device state (current temperature) and knows how to change it.
 */
public class Thermostat {
    // Internal device state (used by commands to support undo).
    private int currentTemperature = 20; // default

    public void setTemperature(int temp) {
        System.out.println("Thermostat set to " + temp + "°C");
        currentTemperature = temp;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }
}