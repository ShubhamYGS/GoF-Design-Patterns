package command.impl;

import command.devices.Light;
import command.intf.Command;

/**
 * Concrete Command.
 * Executes: light.off() | Undo: light.on()
 */
public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}