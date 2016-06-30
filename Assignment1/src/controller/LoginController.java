package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Session;
import model.User;
import model.UserDB;
import view.SignUpJavaFXView;
import view.WelcomeJavaFXView;

public class LoginController {
    @FXML
    TextField username;
    @FXML
    TextField pw;
    @FXML
    Label alert;

    public void authenticate() throws Exception {
        User user = this.attemptLogin(username.getText(), pw.getText());

        if (user != null) {
            Session.setCurrentUser(user);
            this.openWelcomeView(user);
        } else {
            alert.setText("Couldn't log you in.");
            alert.setStyle("-fx-text-fill: #c66;");
        }
    }

    public User attemptLogin(String username, String password) {
        for (User user : UserDB.getUsers()) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) return user;
            }
        }

        return null;
    }

    public void openSignUpView() throws Exception {
        new SignUpJavaFXView();
        this.closeWindow();
    }

    public void openWelcomeView(User user) throws Exception {
        new WelcomeJavaFXView(user.getUsername());
        this.closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) username.getScene().getWindow();
        stage.close();
    }
}
