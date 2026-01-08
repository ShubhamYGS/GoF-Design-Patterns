package proxy.proxy_type;

import proxy.impl.HighResolutionImage;
import proxy.intf.Image;

// Virtual Proxy: creates the real image only when it's actually needed (lazy loading)
public class VirtualProxy implements Image {
    private String fileName;

    // Real object is created on demand
    private HighResolutionImage realImage;

    public VirtualProxy(String fileName) {
        this.fileName = fileName;
        System.out.println("[VirtualProxy] Created for: " + fileName + ". Real image not loaded yet.");
    }

    @Override
    public void display() {
        // Lazy loading: Create the real image only when display() is called
        if (realImage == null) {
            System.out.println("[VirtualProxy] display() called. Loading real image: " + fileName);
            realImage = new HighResolutionImage(fileName);
        } else {
            System.out.println("[VirtualProxy] display() called. Real image already loaded: " + fileName);
        }
        realImage.display();
    }

    @Override
    public String getFileName() {
        // Getting a name shouldn't force an expensive load
        return fileName;
    }
}
