package composite.impl;

import composite.intf.FileSystemItem;

// Leaf object in the Composite pattern (cannot contain other items)
public class File implements FileSystemItem {
    private final String name;
    private final int size; // size in KB

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        // A file's size is just its own size
        return size;
    }

    @Override
    public void printStructure(String indent) {
        // Print this file with indentation (used by parent folders)
        System.out.println(indent + "- " + name + " (" + size + " KB)");
    }

    @Override
    public void delete() {
        // In a real system, we'd delete from disk; here we just log the action
        System.out.println("Deleting file: " + name);
    }
}