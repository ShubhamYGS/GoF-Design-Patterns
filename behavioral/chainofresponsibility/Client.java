package chainofresponsibility;

import chainofresponsibility.impl.RequestHandler;
import chainofresponsibility.intf.*;
import chainofresponsibility.model.Request;

/**
 * Demo client for the Chain of Responsibility pattern.
 * Builds a chain of handlers and sends requests through it.
 */
public class Client {
    public static void main(String[] args) {
        // Each handler is one step in the pipeline (auth → authorization → rate limit → validation → business).
        RequestHandler auth = new AuthHandler();
        RequestHandler authorization = new AuthorizationHandler();
        RequestHandler rateLimit = new RateLimitHandler();
        RequestHandler validation = new ValidationHandler();
        RequestHandler businessLogic = new BusinessLogicHandler();

        // Build the chain: each handler forwards to the next one if it approves the request.
        auth.setNext(authorization);
        authorization.setNext(rateLimit);
        rateLimit.setNext(validation);
        validation.setNext(businessLogic);

        // Send a request through the chain (happy path)
        Request request = new Request("john", "ADMIN", 10, "{ \"data\": \"valid\" }");
        auth.handle(request);

        System.out.println("\n--- Trying an invalid request ---");
        // This one should get rejected early and stop the chain.
        Request badRequest = new Request(null, "USER", 150, "");
        auth.handle(badRequest);
    }
}