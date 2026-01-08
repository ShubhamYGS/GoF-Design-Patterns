package facade.oldimpl;

/**
 * Subsystem class: represents a deployment environment/server.
 * It can receive an artifact and then activate it (make it live).
 */
public class DeploymentTarget {
    public void transferArtifact(String artifactPath, String server) {
        System.out.println("Deployment: Transferring " + artifactPath + " to " + server + "...");
        simulateDelay(1000); // Simulate network transfer time
        System.out.println("Deployment: Transfer complete.");
    }

    public void activateNewVersion(String server) {
        System.out.println("Deployment: Activating new version on " + server + "...");
        simulateDelay(500); // Simulate restarting/switching traffic
        System.out.println("Deployment: Now live on " + server + "!");
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