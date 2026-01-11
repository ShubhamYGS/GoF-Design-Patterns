package chainofresponsibility.intf;

import chainofresponsibility.impl.RequestHandler;
import chainofresponsibility.model.Request;

/**
 * Base class that contains the chaining boilerplate.
 * Concrete handlers focus only on their own check and call forward(...) on success.
 */
abstract class BaseHandler implements RequestHandler {
    // Next handler in the chain (null means this is the end).
    protected RequestHandler next;

    @Override
    public void setNext(RequestHandler next) {
        this.next = next;
    }

    /**
     * Pass the request to the next handler (if any).
     */
    protected void forward(Request request) {
        if (next != null) {
            next.handle(request);
        }
    }
}