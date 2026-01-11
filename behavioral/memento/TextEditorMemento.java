package memento;

/**
 * Role: Memento.
 * Immutable snapshot of TextEditor state.
 */
class TextEditorMemento {
    private final String state;

    public TextEditorMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}