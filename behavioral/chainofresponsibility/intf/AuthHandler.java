package chainofresponsibility.intf;

import chainofresponsibility.model.Request;

/**
 * Concrete handler: checks that a user is present ("authenticated").
 */
public class AuthHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        // Guard clause: reject and stop the chain if the user is missing.
        if (request.user == null) {
            System.out.println("AuthHandler: ❌ User not authenticated.");
            return; // Stop the chain
        }
        System.out.println("AuthHandler: ✅ Authenticated.");
        forward(request);
    }
}