package mediator.concretemediator;

import mediator.abstractclass.UIComponent;
import mediator.concrete.Button;
import mediator.concrete.Label;
import mediator.concrete.TextField;
import mediator.intf.UIMediator;

/**
 * Concrete Mediator.
 * Coordinates the login form: enables/disables the button and performs the login check.
 */
public class FormMediator implements UIMediator {
    private TextField usernameField;
    private TextField passwordField;
    private Button loginButton;
    private Label statusLabel;

    public void setUsernameField(TextField usernameField) {
        this.usernameField = usernameField;
    }

    public void setPasswordField(TextField passwordField) {
        this.passwordField = passwordField;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    public void setStatusLabel(Label statusLabel) {
        this.statusLabel = statusLabel;
    }

    @Override
    public void componentChanged(UIComponent component) {
        // If a text field changes, enable the login button only when both fields have input.
        if (component == usernameField || component == passwordField) {
            boolean enableButton = !usernameField.getText().isEmpty() &&
                    !passwordField.getText().isEmpty();
            loginButton.setEnabled(enableButton);
        }
        // If the button is clicked, validate credentials and show result in the label.
        else if (component == loginButton) {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if ("admin".equals(username) && "1234".equals(password)) {
                statusLabel.setText("✅ Login successful!");
            } else {
                statusLabel.setText("❌ Invalid credentials.");
            }
        }
    }
}