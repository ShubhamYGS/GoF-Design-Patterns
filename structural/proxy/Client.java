package proxy;

import proxy.intf.Image;
import proxy.proxy_type.*;

public class Client {
    public static void main(String[] args) {
        System.out.println("--- Demonstrating various Proxy Design Patterns ---");

        // 1) Virtual Proxy (lazy loading)
        System.out.println("\n-------------------------------------------");
        System.out.println("1. Virtual Proxy (Lazy Loading):");
        System.out.println("---------------------------------------------");

        Image virtualImage1 = new VirtualProxy("HighResPhoto1.jpg");
        Image virtualImage2 = new VirtualProxy("HighResPhoto2.jpg"); // never displayed -> never loaded

        System.out.println("\nVirtual proxies initialized. No real images loaded from disk yet.");
        System.out.println("Getting file name for image1 (no load):" + virtualImage1.getFileName());

        System.out.println("\nUser requests to display :" + virtualImage1.getFileName());
        virtualImage1.display();    // Triggers loading of the real image

        System.out.println("\nUser requests to display :" + virtualImage1.getFileName() + " again.");
        virtualImage1.display();    // Uses already loaded image. No new load or object creation.

        System.out.println("\nNotice: " + virtualImage2.getFileName() + " was never displayed, so its real image was never loaded.");

        // 2) Protection Proxy (access control)
        System.out.println("\n-------------------------------------------");
        System.out.println("2. Protection Proxy: Controls access based on permissions.");
        System.out.println("\n-------------------------------------------");

        System.out.println("\nAttempting to display 'confidential_report.pdf' with different roles:");
        Image adminImage = new ProtectionProxy("confidential_report.pdf", "Admin");
        adminImage.display();
        System.out.println("Admin can get filename: " + adminImage.getFileName());

        Image userImage = new ProtectionProxy("confidential_report.pdf", "User");
        userImage.display();
        System.out.println("User can get filename: " + userImage.getFileName());

        Image guestImage = new ProtectionProxy("confidential_report.pdf", "Guest");
        guestImage.display(); // Access denied
        System.out.println("Guest can get filename: " + guestImage.getFileName()); // Permitted);

        Image unknownImage = new ProtectionProxy("confidential_report.pdf", "Unknown");
        unknownImage.display(); // Access denied
        System.out.println("Unknown role trying to get filename: " + unknownImage.getFileName()); // Denied for filename too

        // 3) Remote Proxy (represents a remote object)
        System.out.println("\n-------------------------------------------");
        System.out.println("3. Remote Proxy: Represents a remote object.");
        System.out.println("\n-------------------------------------------");

        Image remoteImage = new RemoteProxy("http://remoteserver.com/assets/holiday_banner.jpg");

        System.out.println("\nRemote proxy initialized for: " + remoteImage.getFileName());
        System.out.println("User requests to display remote image:");
        remoteImage.display(); // Simulates connecting to remote server


        // 4) Caching Proxy (cache expensive results)
        System.out.println("\n--------------------------------------------");
        System.out.println("4. Caching Proxy: Caches expensive results.");
        System.out.println("--------------------------------------------");

        Image cachedImage = new CachingProxy("product_thumbnail.jpg");

        System.out.println("\nFirst display of " + cachedImage.getFileName() + ":");
        cachedImage.display(); // Triggers real image load and caches it

        System.out.println("\nSecond display of " + cachedImage.getFileName() + ":");
        cachedImage.display(); // Uses cached image, no real image load delay

        System.out.println("\nThird display of " + cachedImage.getFileName() + ":");
        cachedImage.display(); // Uses cached image again

        //  5) Smart Proxy Demonstration (Logging, Reference Counting, Monitoring) ---
        System.out.println("\n--------------------------------------------");
        System.out.println("5. Smart Proxy: Adds additional logic before/after calls.");
        System.out.println("--------------------------------------------");

        SmartProxy smartImage = new SmartProxy("user_profile_pic.tiff");
        System.out.println("\nSmart proxy initialized for: " + smartImage.getFileName());

        System.out.println("\nFirst access to display smart image:");
        smartImage.display();
        System.out.println("Current access count for smart image: " + smartImage.getAccessCount());

        System.out.println("\nSecond access to display smart image:");
        smartImage.display();
        System.out.println("Current access count for smart image: " + smartImage.getAccessCount());

        System.out.println("\nAccessing filename via smart image:");
        System.out.println("Filename: " + smartImage.getFileName());
        System.out.println("Current access count for smart image: " + smartImage.getAccessCount());

        System.out.println("\n--- Proxy Design Patterns Demonstration Finished ---");

    }
}
