package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Session;
import model.User;
import view.LoginJavaFXView;

/**
 * Welcome Screen Controller
 */
public class WelcomeController {
    @FXML
    Label username;

    @FXML
    ImageView photo;

    /**
     * after initialize
     */
    public void initialize() {
        User user = Session.getCurrentUser();

        username.setText(user.getUsername());

        if (!user.getPhoto().isEmpty()) photo.setImage(new Image("file:" + user.getPhoto()));
    }

    /**
     * logout
     * @throws Exception
     */
    public void logOut() throws Exception {
        new LoginJavaFXView().loadView();
        this.closeWindow();
    }

    /**
     * Closes the currently opened window
     */
    private void closeWindow() {
        Stage stage = (Stage) username.getScene().getWindow();
        stage.close();
    }

}
