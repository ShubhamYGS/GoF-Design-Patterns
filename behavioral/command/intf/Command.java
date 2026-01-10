package command.intf;

/**
 * Command contract.
 * A command represents a request that can be executed now and undone later.
 */
public interface Command {
    void execute();

    // Reverts what execute() did (how it reverts depends on the command).
    void undo();
}