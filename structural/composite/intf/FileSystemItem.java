package composite.intf;

// Common contract for both files (leaf) and folders (composite)
public interface FileSystemItem {
    // Return size of this item (for folders, it's the total size of all children)
    int getSize();

    // Print this item and its children using the given indentation
    void printStructure(String indent);

    // Delete this item (folders delete all children first)
    void delete();
}