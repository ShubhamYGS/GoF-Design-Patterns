package proxy.intf;

// Common contract for the real object and all proxy variants
public interface Image {
    // Show/render the image
    void display();

    // Return the image identifier (in this demo, it's the file name or derived name)
    String getFileName();
}