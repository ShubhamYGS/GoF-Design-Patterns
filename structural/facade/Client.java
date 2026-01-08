package facade;

/**
 * Demo entry point for the Facade pattern.
 * The client talks to one simple API (DeploymentFacade) instead of many subsystem classes.
 */
public class Client {
    public static void main(String[] args) {
        // Facade hides the "messy" deployment steps behind one method call.
        DeploymentFacade deploymentFacade = new DeploymentFacade();

        // Deploy to production
        deploymentFacade.deployApplication("main", "prod.server.example.com");

        // Deploy a feature branch to staging
        System.out.println("\n--- Deploying feature branch to staging ---");
        deploymentFacade.deployApplication("feature/new-ui", "staging.server.example.com");
    }
}
