package mediator;

import mediator.concrete.Button;
import mediator.concrete.Label;
import mediator.concrete.TextField;
import mediator.concretemediator.FormMediator;

/**
 * Demo client for the Mediator pattern.
 * UI components don't talk to each other directly; they communicate through FormMediator.
 */
public class MediatorApp {
    public static void main(String[] args) {
        FormMediator mediator = new FormMediator();

        // Colleague components (they all share the same mediator).
        TextField usernameField = new TextField(mediator);
        TextField passwordField = new TextField(mediator);
        Button loginButton = new Button(mediator);
        Label statusLabel = new Label(mediator);

        // Wire components into the mediator so it can coordinate them.
        mediator.setUsernameField(usernameField);
        mediator.setPasswordField(passwordField);
        mediator.setLoginButton(loginButton);
        mediator.setStatusLabel(statusLabel);

        // Simulate user interaction
        usernameField.setText("admin");
        passwordField.setText("1234");
        loginButton.click(); // Mediator performs the login check

        System.out.println("\n--- New Attempt with Wrong Password ---");
        passwordField.setText("wrong");
        loginButton.click(); // Mediator returns an error message
    }
}