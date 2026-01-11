package chainofresponsibility.intf;

import chainofresponsibility.model.Request;

/**
 * Concrete handler (usually the last one): runs the actual business action.
 */
public class BusinessLogicHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        System.out.println("BusinessLogicHandler: 🚀 Processing request...");
        // Core application logic goes here
    }
}