package memento;

/**
 * Memento Pattern demo.
 * Roles:
 * - TextEditor: Originator (creates/restores snapshots)
 * - TextEditorMemento: Memento (snapshot)
 * - TextEditorUndoManager: Caretaker (stores snapshots for undo)
 * - Client: wires everything and triggers actions
 */
public class Client {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorUndoManager undoManager = new TextEditorUndoManager();

        editor.type("Hello");
        undoManager.save(editor); // save state: Hello

        editor.type(" World");
        undoManager.save(editor); // save state: Hello World

        editor.type("!");
        System.out.println("Current Content: " + editor.getContent()); // Hello World!

        System.out.println("\n--- Undo 1 ---");
        undoManager.undo(editor); // Back to: Hello World

        System.out.println("\n--- Undo 2 ---");
        undoManager.undo(editor); // Back to: Hello

        System.out.println("\n--- Undo 3 ---");
        undoManager.undo(editor); // Nothing left to undo
    }
}
