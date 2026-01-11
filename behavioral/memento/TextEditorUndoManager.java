package memento;

import java.util.Stack;

/**
 * Role: Caretaker.
 * Keeps a history of mementos so we can undo, without looking inside the editor state.
 */
class TextEditorUndoManager {
    private final Stack<TextEditorMemento> history = new Stack<>();

    public void save(TextEditor editor) {
        // Ask the originator for a snapshot and store it.
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            // Restore the most recent snapshot.
            editor.restore(history.pop());
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}