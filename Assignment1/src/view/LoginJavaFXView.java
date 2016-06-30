package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import model.UserDB;
import model.UserIO;

import java.io.IOException;
import java.util.ArrayList;

public class LoginJavaFXView extends Application {

    public LoginJavaFXView() throws Exception {
//        Stage signupStage = new Stage();
//        start(signupStage);
    }

    public void loadView() throws Exception {
        Stage signupStage = new Stage();
        start(signupStage);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        loadDB();

        Parent loginView = FXMLLoader.load(getClass().getResource("LoginJavaFX.fxml"));
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(loginView, 600, 400));
        primaryStage.show();
    }

    public void loadDB() {
        try {
            UserDB.setUsers((ArrayList<User>) UserIO.readUsers());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.print("Fail to open users.dat file.");
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
