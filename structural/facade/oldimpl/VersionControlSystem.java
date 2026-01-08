package facade.oldimpl;

/**
 * Subsystem class: represents a version control system (e.g., Git).
 * Used to fetch the latest code before building and deploying.
 */
public class VersionControlSystem {
    public void pullLatestChanges(String branch) {
        System.out.println("VCS: Pulling latest changes from '" + branch + "'...");
        simulateDelay();
        System.out.println("VCS: Pull complete.");
    }

    private void simulateDelay() {
        try {
            Thread.sleep(1000); // Simulate network/time cost of fetching changes
        } catch (InterruptedException e) {
            // For demo simplicity we just print the stack trace.
            e.printStackTrace();
        }
    }
}