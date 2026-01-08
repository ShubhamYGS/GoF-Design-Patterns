package proxy.impl;

import proxy.intf.Image;

// Real object ("Real Subject") representing an expensive-to-load image
public class HighResolutionImage implements Image {
    private String fileName;

    // Simulated image payload kept in memory (large in real life)
    private byte[] imageData;

    public HighResolutionImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk(); // Expensive operation (simulated)
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image: " + fileName + " from disk (Expensive Operation)...");
        try {
            Thread.sleep(2000); // Simulate disk I/O delay
            this.imageData = new byte[10 * 1024 * 1024]; // Simulate ~10MB memory usage
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Image " + fileName + " loaded successfully.");
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}