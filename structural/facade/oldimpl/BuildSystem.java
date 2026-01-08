package facade.oldimpl;

/**
 * Subsystem class: represents a build tool (e.g., Maven/Gradle) that compiles the project
 * and produces a deployable artifact (like a JAR).
 */
public class BuildSystem {
    public boolean compileProject() {
        System.out.println("BuildSystem: Compiling project...");
        simulateDelay(2000); // Simulate time taken by a real build
        System.out.println("BuildSystem: Build successful.");
        return true;
    }

    public String getArtifactPath() {
        // In a real system this would be discovered from the build output.
        String path = "target/myapplication-1.0.jar";
        System.out.println("BuildSystem: Artifact located at " + path);
        return path;
    }

    private void simulateDelay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // For demo simplicity we just print the stack trace.
            e.printStackTrace();
        }
    }
}