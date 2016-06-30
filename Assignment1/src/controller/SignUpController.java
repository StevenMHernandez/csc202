package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import model.User;
import model.UserDB;
import model.UserIO;
import view.LoginJavaFXView;

import java.io.File;
import java.util.regex.Pattern;

public class SignUpController {
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField uname;
    @FXML
    PasswordField pw1;
    @FXML
    PasswordField pw2;
    @FXML
    TextField email;
    @FXML
    DatePicker dob;
    @FXML
    TextField gender;
    @FXML
    Button photo;
    @FXML
    Label alert;

    public void signUp() {
        /*
         *
         * Validation
         *
         */
        // check required fields
        if (!areAllRequiredFieldsFilled()) {
            errorAlert("Fields in RED are REQUIRED");
            return;
        } else if (!pw1.getText().equals(pw2.getText())) { // pw1 and pw2 are not the same
            errorAlert("Password fields are not the same");
            styleTextField(pw1, "#c66");
            styleTextField(pw2, "#c66");
            return;
        } else if (!isValidEmail(email.getText())) {
            errorAlert("Email does not appear to be valid. `xxxx@mail.xxx`");
            return;
        } else if (!isValidPassword(pw1.getText())) {
            errorAlert("Password must have at least 1 number, 1 upper case letter, 1 lower case letter, 1 special character");
            return;
        }

        /*
         *
         * Success, create the account
         *
         */
        successAlert("SUCCESS");

        User user = new User(uname.getText(), "email", "phone", pw1.getText(), "");

        // add to some list?

        UserDB.getUsers().add(user);

        System.out.println(UserDB.getUsers());

        try {
            UserIO.writeUsers(UserDB.getUsers());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void styleTextField(TextField field, String color) {
        field.setStyle("-fx-background-color: " + color + ";");
    }

    public void styleTextField(DatePicker field, String color) {
        field.setStyle("-fx-background-color: " + color + ";");
    }

    public void openLoginView() throws Exception {
        new LoginJavaFXView().loadView();
    }

    public void selectPhoto() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        File file = chooser.showOpenDialog(photo.getScene().getWindow());

        // save the file somewhere in this controller
    }

    /*
     *
     * Validation methods
     *
     */

    private boolean isValidPassword(String password) {
        Pattern number = Pattern.compile("[0-9]");
        Pattern upperCase = Pattern.compile("[A-Z]");
        Pattern lowerCase = Pattern.compile("[a-z]");
        Pattern specialCharacter = Pattern.compile("[^A-Za-z0-9\\s]");

        return (number.matcher(password).find()
                && upperCase.matcher(password).find()
                && lowerCase.matcher(password).find()
                && specialCharacter.matcher(password).find());
    }

    private boolean isValidEmail(String email) {
        return email.contains("@mail.");
    }

    private boolean areAllRequiredFieldsFilled() {
        boolean result = true;

        if (!checkRequiredField(firstName)) result = false;
        if (!checkRequiredField(lastName)) result = false;
        if (!checkRequiredField(dob)) result = false;
        if (!checkRequiredField(gender)) result = false;
        if (!checkRequiredField(uname)) result = false;
        if (!checkRequiredField(email)) result = false;
        if (!checkRequiredField(pw1)) result = false;
        if (!checkRequiredField(pw2)) result = false;

        return result;
    }

    private boolean checkRequiredField(TextField field) {
        if (field.getText().isEmpty()) {
            styleTextField(field, "#c66");
            return false;
        }

        styleTextField(field, "white");
        return true;
    }

    private boolean checkRequiredField(DatePicker field) {
        if (field.getValue() == null) {
            styleTextField(field, "#c66");
            return false;
        }

        styleTextField(field, "white");
        return true;
    }

    /*
     *
     * Alert methods
     *
     */

    private void showAlert(String alertString, String color) {
        alert.setText(alertString);
        alert.setStyle("-fx-text-fill: " + color + ";");
    }

    public void errorAlert(String alertString) {
        showAlert(alertString, "#c66");
    }

    public void successAlert(String alertString) {
        showAlert(alertString, "#6cc");
    }
}
