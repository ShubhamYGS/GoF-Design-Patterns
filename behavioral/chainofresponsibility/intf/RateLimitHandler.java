package chainofresponsibility.intf;

import chainofresponsibility.model.Request;

/**
 * Concrete handler: blocks requests that exceed a simple rate limit.
 */
public class RateLimitHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if (request.requestCount >= 100) {
            System.out.println("RateLimitHandler: ❌ Rate limit exceeded.");
            return;
        }
        System.out.println("RateLimitHandler: ✅ Within rate limit.");
        forward(request);
    }
}