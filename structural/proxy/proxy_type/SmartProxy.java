package proxy.proxy_type;

import proxy.impl.HighResolutionImage;
import proxy.intf.Image;

// Smart Proxy: adds extra behavior (logging/metrics) around calls to the real image
public class SmartProxy implements Image {
    private HighResolutionImage realImage; // In real apps, this could wrap another proxy too
    private String fileName;

    private int accessCount; // Number of calls made through this proxy
    private long lastAccessTime; // Timestamp of last access

    public SmartProxy(String fileName) {
        this.fileName = fileName;
        this.accessCount = 0;
        this.lastAccessTime = 0;
        System.out.println("[SmartProxy] Created for: " + fileName + ". Access count initialized to 0.");
    }

    private void createRealImageIfNeeded() {
        if (realImage == null) {
            System.out.println("[SmartProxy] Creating real image for " + fileName);
            // This could be lazy-loaded, similar to a virtual proxy
            realImage = new HighResolutionImage(fileName);
        }
    }

    @Override
    public void display() {
        // Do extra work before delegating
        System.out.println("[SmartProxy] Logging: display() call for " + fileName);
        accessCount++;
        lastAccessTime = System.currentTimeMillis();

        createRealImageIfNeeded();
        realImage.display();

        // Do extra work after delegating
        System.out.println(
                "[SmartProxy] Monitoring: " + fileName + " displayed. " +
                        "Total access count: " + accessCount + ", " +
                        "Last access time: " + new java.util.Date(lastAccessTime)
        );
    }

    @Override
    public String getFileName() {
        System.out.println("[SmartProxy] Logging: getFileName() call for " + fileName);
        accessCount++;  // Increment access count
        lastAccessTime = System.currentTimeMillis();    // Update last access time
        return fileName;    // No need to load the image just to get the file name
    }

    public int getAccessCount() {
        return accessCount;
    }
}
