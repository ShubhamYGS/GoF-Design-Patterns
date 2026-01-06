package composite;

import composite.impl.File;
import composite.impl.Folder;
import composite.intf.FileSystemItem;

public class Client {
    public static void main(String[] args) {
        // Leaf nodes (individual files)
        FileSystemItem file1 = new File("readme.txt", 5);
        FileSystemItem file2 = new File("photo.jpg", 1500);
        FileSystemItem file3 = new File("data.csv", 300);

        // Composite nodes (folders) can contain files and/or other folders
        Folder documents = new Folder("Documents");
        documents.addItem(file1);
        documents.addItem(file3);

        Folder pictures = new Folder("Pictures");
        pictures.addItem(file2);

        // Root folder that contains other folders
        Folder home = new Folder("Home");
        home.addItem(documents);
        home.addItem(pictures);

        System.out.println("---- File Structure ----");
        home.printStructure("");

        // Getting size works the same way for a file or a folder
        System.out.println("\nTotal Size: " + home.getSize() + " KB");

        // Deleting a folder deletes everything inside (recursively)
        System.out.println("\n---- Deleting All ----");
        home.delete();
    }
}