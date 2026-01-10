package command.impl;

import command.devices.Light;
import command.intf.Command;

/**
 * Concrete Command.
 * Executes: light.on() | Undo: light.off()
 */
public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}