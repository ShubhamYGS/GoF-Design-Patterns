package proxy.proxy_type;

import proxy.impl.HighResolutionImage;
import proxy.intf.Image;

// Caching Proxy: stores the real image after the first load to avoid repeating expensive work
public class CachingProxy implements Image {
    private String fileName;

    // Cache of the real object
    private HighResolutionImage cachedImage;

    public CachingProxy(String fileName) {
        this.fileName = fileName;
        System.out.println("[CachingProxy] Created for: " + fileName + ". Image not cached yet.");
    }


    @Override
    public void display() {
        if (cachedImage == null) {
            System.out.println("[CachingProxy] Image not cached. Loading real image: " + fileName);
            cachedImage = new HighResolutionImage(fileName); // Load the real image
            System.out.println("[CachingProxy] Image " + fileName + " loaded and cached.");
        } else {
            System.out.println("[CachingProxy] Using cached image for: " + fileName);
        }
        cachedImage.display();  // Display from cache
    }

    @Override
    public String getFileName() {
        // Getting the name is cheap; no need to load anything
        return fileName;
    }
}
