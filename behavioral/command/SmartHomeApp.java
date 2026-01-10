package command;

import command.devices.Light;
import command.devices.Thermostat;
import command.impl.LightOffCommand;
import command.impl.LightOnCommand;
import command.impl.SetTemperatureCommand;
import command.intf.Command;

/**
 * Client (demo) for the Command pattern.
 * Creates receivers + commands, then uses an invoker (SmartButton) to execute and undo actions.
 */
public class SmartHomeApp {
    public static void main(String[] args) {
        // Receivers: the real devices that know how to do the work.
        Light light = new Light();
        Thermostat thermostat = new Thermostat();

        // Commands: wrap a device action so it can be executed/undone later.
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command setTemp22 = new SetTemperatureCommand(thermostat, 22);

        // Invoker: triggers commands (a "button" doesn't need to know device details).
        SmartButton button = new SmartButton();

        // Simulate usage
        System.out.println("→ Pressing Light ON");
        button.setCommand(lightOn);
        button.press();

        System.out.println("→ Pressing Set Temp to 22°C");
        button.setCommand(setTemp22);
        button.press();

        System.out.println("→ Pressing Light OFF");
        button.setCommand(lightOff);
        button.press();

        // Undo sequence
        System.out.println("\n↶ Undo Last Action");
        button.undoLast();  // undo Light OFF

        System.out.println("↶ Undo Previous Action");
        button.undoLast();  // undo Set Temp

        System.out.println("↶ Undo Again");
        button.undoLast();  // undo Light ON
    }
}