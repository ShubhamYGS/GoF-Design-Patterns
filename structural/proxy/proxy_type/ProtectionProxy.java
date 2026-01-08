package proxy.proxy_type;

import proxy.impl.HighResolutionImage;
import proxy.intf.Image;

// Protection Proxy: checks permissions before allowing access to the real image
public class ProtectionProxy implements Image {
    private HighResolutionImage realImage;
    private String fileName;

    // Example roles used in this demo: Admin, User, Guest
    private String userRole;

    public ProtectionProxy(String fileName, String userRole) {
        this.fileName = fileName;
        this.userRole = userRole;
        System.out.println("[ProtectionProxy] Created for: " + fileName + " with role: " + userRole);
    }

    private void createRealImageIfNeeded() {
        // Create the real object only when we actually need it
        if (realImage == null) {
            System.out.println("[ProtectionProxy] Creating real image for " + fileName);
            realImage = new HighResolutionImage(fileName);
        }
    }

    @Override
    public void display() {
        // Only Admin and User can view the image
        if ("Admin".equalsIgnoreCase(userRole) || "User".equalsIgnoreCase(userRole)) {
            System.out.println("[ProtectionProxy] User " + userRole + " has permission to display: " + fileName);
            createRealImageIfNeeded();
            realImage.display();
        } else {
            System.out.println("[ProtectionProxy] Access denied for role: " + userRole + " to display image: " + fileName);
        }
    }

    @Override
    public String getFileName() {
        // This demo allows Guest to see the name, but blocks unknown roles entirely
        if ("Admin".equalsIgnoreCase(userRole) || "User".equalsIgnoreCase(userRole) || "Guest".equalsIgnoreCase(userRole)) {
            return fileName;
        }

        System.out.println("[ProtectionProxy] Access denied for role: " + userRole + " to get file name of image: " + fileName);
        return "Unauthorized";
    }
}
