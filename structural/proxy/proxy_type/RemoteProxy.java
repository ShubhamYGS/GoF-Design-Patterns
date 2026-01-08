package proxy.proxy_type;

import proxy.intf.Image;

// Remote Proxy: represents an image that lives on another machine (network call simulated)
public class RemoteProxy implements Image {
    private String imageUrl; // URL of the remote image

    public RemoteProxy(String imageUrl) {
        this.imageUrl = imageUrl;
        System.out.println("[RemoteProxy] Created for remote image URL: " + imageUrl);
    }

    @Override
    public void display() {
        System.out.println("[RemoteProxy] Attempting to connect to remote server to display image from " + imageUrl);
        try {
            // Simulate network latency
            Thread.sleep(1500); // 1.5 seconds delay
            System.out.println("[RemoteProxy] Successfully retrieved and displaying image from: " + imageUrl);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[RemoteProxy] Failed to connect to " + imageUrl);
        }
    }

    @Override
    public String getFileName() {
        // For a remote image,the "fileName" might be it's URL or a derived name
        return "Remote-" + imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
    }
}
