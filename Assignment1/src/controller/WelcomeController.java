package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.User;
import model.UserDB;
import view.LoginJavaFXView;
import view.SignUpJavaFXView;

public class WelcomeController {
    @FXML
    Label username;

    public void logOut() throws Exception {
        new LoginJavaFXView().loadView();
    }

}
