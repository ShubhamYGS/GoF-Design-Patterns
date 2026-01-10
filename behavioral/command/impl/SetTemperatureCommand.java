package command.impl;

import command.devices.Thermostat;
import command.intf.Command;

/**
 * Concrete Command.
 * Sets the thermostat temperature and supports undo by restoring the previous value.
 */
public class SetTemperatureCommand implements Command {
    private final Thermostat thermostat;
    private final int newTemperature;

    // Stored during execute() so undo() can restore the old value.
    private int previousTemperature;

    public SetTemperatureCommand(Thermostat thermostat, int temperature) {
        this.thermostat = thermostat;
        this.newTemperature = temperature;
    }

    @Override
    public void execute() {
        previousTemperature = thermostat.getCurrentTemperature();
        thermostat.setTemperature(newTemperature);
    }

    @Override
    public void undo() {
        thermostat.setTemperature(previousTemperature);
    }
}