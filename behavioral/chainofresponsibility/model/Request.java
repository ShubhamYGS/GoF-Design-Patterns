package chainofresponsibility.model;

/**
 * Simple request object that travels through the handler chain.
 * (Fields are public here to keep the demo short.)
 */
public class Request {
    public String user;
    public String userRole;
    public int requestCount;
    public String payload;

    public Request(String user, String role, int requestCount, String payload) {
        this.user = user;
        this.userRole = role;
        this.requestCount = requestCount;
        this.payload = payload;
    }
}