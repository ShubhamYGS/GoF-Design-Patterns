package composite.impl;

import composite.intf.FileSystemItem;

import java.util.ArrayList;
import java.util.List;

// Composite object in the Composite pattern (can contain files and other folders)
public class Folder implements FileSystemItem {
    private final String name;

    // Child items can be either File (leaf) or Folder (another composite)
    private final List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    // Add a file or sub-folder into this folder
    public void addItem(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public int getSize() {
        // Folder size = sum of sizes of all its children
        int total = 0;
        for (FileSystemItem item : children) {
            total += item.getSize();
        }
        return total;
    }

    @Override
    public void printStructure(String indent) {
        // Print the folder name, then recursively print children
        System.out.println(indent + "+ " + name + "/");
        for (FileSystemItem item : children) {
            item.printStructure(indent + "  ");
        }
    }

    @Override
    public void delete() {
        // Delete children first, then delete this folder
        for (FileSystemItem item : children) {
            item.delete();
        }
        System.out.println("Deleting folder: " + name);
    }
}