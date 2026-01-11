package chainofresponsibility.impl;

import chainofresponsibility.model.Request;

/**
 * Common contract for every link in the chain.
 * A handler can either stop the request or forward it to the next handler.
 */
public interface RequestHandler {
    // Connects the next handler in the chain.
    void setNext(RequestHandler next);

    // Performs this handler's check/work and decides whether to continue.
    void handle(Request request);
}