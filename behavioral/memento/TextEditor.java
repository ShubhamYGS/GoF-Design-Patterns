package memento;

/**
 * Role: Originator.
 * Holds the current text and can create/restore snapshots (mementos).
 */
class TextEditor {
    private String content = "";

    public void type(String newText) {
        content += newText;
        System.out.println("Typed: " + newText);
    }

    public String getContent() {
        return content;
    }

    // Creates a snapshot of the current content.
    public TextEditorMemento save() {
        System.out.println("Saving state: \"" + content + "\"");
        return new TextEditorMemento(content);
    }

    // Restores the content from a previously saved snapshot.
    public void restore(TextEditorMemento memento) {
        content = memento.getState();
        System.out.println("Restored state to: \"" + content + "\"");
    }
}