package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.User;
import model.UserDB;
import view.SignUpJavaFXView;

public class LoginController {
    @FXML
    TextField username;
    @FXML
    TextField pw;

    public void authenticate() {
        System.out.println(username.getText());
        System.out.println(pw.getText());

        System.out.println(attemptLogin(username.getText(), pw.getText()) ? "Hey!" : "Wrong");
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
}
