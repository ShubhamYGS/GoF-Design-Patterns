package facade;

import facade.oldimpl.BuildSystem;
import facade.oldimpl.DeploymentTarget;
import facade.oldimpl.TestingFramework;
import facade.oldimpl.VersionControlSystem;

/**
 * Facade: provides one simple method to deploy an application.
 * Internally it coordinates several subsystem classes (VCS, build, tests, deployment).
 */
class DeploymentFacade {
    // Subsystems used by the facade. The client doesn't need to know these exist.
    private VersionControlSystem vcs = new VersionControlSystem();
    private BuildSystem buildSystem = new BuildSystem();
    private TestingFramework testingFramework = new TestingFramework();
    private DeploymentTarget deploymentTarget = new DeploymentTarget();

    /**
     * Runs a full deployment pipeline:
     * 1) pull code, 2) build, 3) test, 4) transfer artifact, 5) activate.
     *
     * @return true if all steps succeeded; false if any step fails.
     */
    public boolean deployApplication(String branch, String serverAddress) {
        System.out.println("\nFACADE: --- Initiating FULL DEPLOYMENT for branch: " + branch + " to " + serverAddress + " ---");
        boolean success = true;

        try {
            // Get the latest code for the requested branch.
            vcs.pullLatestChanges(branch);

            // Fail fast: don't continue if the build fails.
            if (!buildSystem.compileProject()) {
                System.err.println("FACADE: DEPLOYMENT FAILED - Build compilation failed.");
                return false;
            }

            // The build output (artifact) is what we will deploy to the server.
            String artifactPath = buildSystem.getArtifactPath();

            // Run automated checks before deploying anything.
            if (!testingFramework.runUnitTests()) {
                System.err.println("FACADE: DEPLOYMENT FAILED - Unit tests failed.");
                return false;
            }

            if (!testingFramework.runIntegrationTests()) {
                System.err.println("FACADE: DEPLOYMENT FAILED - Integration tests failed.");
                return false;
            }

            // Publish and switch the server to the new version.
            deploymentTarget.transferArtifact(artifactPath, serverAddress);
            deploymentTarget.activateNewVersion(serverAddress);

            System.out.println("FACADE: APPLICATION DEPLOYED SUCCESSFULLY to " + serverAddress + "!");
        } catch (Exception e) {
            // Any unexpected error should stop the deployment and return "false".
            System.err.println("FACADE: DEPLOYMENT FAILED - An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
            success = false;
        }

        return success;
    }
}