package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.User;
import model.UserDB;
import view.SignUpJavaFXView;
import view.WelcomeJavaFXView;

public class LoginController {
    @FXML
    TextField username;
    @FXML
    TextField pw;

    public void authenticate() throws Exception {
        if (this.attemptLogin(username.getText(), pw.getText())) {
            this.openWelcomeView(username.getText());
        }
    }

    public boolean attemptLogin(String username, String password) {
        for (User user : UserDB.getUsers()) {
            if (user.getUsername().equals(username)) {
                return user.getPassword().equals(password);
            }
        }

        return false;
    }

    public void openSignUpView() throws Exception {
        new SignUpJavaFXView();
    }

    public void openWelcomeView(String username) throws Exception {
        new WelcomeJavaFXView(username);
    }
}
