package command;

import command.intf.Command;

import java.util.Stack;

/**
 * Invoker in the Command pattern.
 * Acts like a programmable button: it runs the current command and keeps history for undo.
 */
class SmartButton {
    // The command that will run when press() is called.
    private Command currentCommand;

    // Simple undo history (last executed command is undone first).
    private final Stack<Command> history = new Stack<>();

    public void setCommand(Command command) {
        this.currentCommand = command;
    }

    public void press() {
        if (currentCommand != null) {
            currentCommand.execute();
            history.push(currentCommand);
        } else {
            System.out.println("No command assigned.");
        }
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}