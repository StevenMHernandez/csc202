package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Hospital;
import model.HospitalDB;
import model.Session;
import model.User;
import utils.BinarySearchTree;
import view.LoginJavaFXView;

/**
 * Welcome Screen Controller
 */
public class WelcomeController {

    public TableView table;

    @FXML
    Label username;

    @FXML
    ImageView photo;

    private final ObservableList<Hospital> data = FXCollections.observableArrayList();

    /**
     * after initialize
     */
    public void initialize() throws Exception {
        User user = Session.getCurrentUser();

        username.setText(user.getUsername());

        if (!user.getPhoto().isEmpty()) photo.setImage(new Image("file:" + user.getPhoto()));


        // Load hospitals
        BinarySearchTree<Hospital> hospitals = new HospitalDB().getList();

        hospitals.reset(BinarySearchTree.IN_ORDER);

        Hospital hospital = null;
        hospital = hospitals.getNext(BinarySearchTree.IN_ORDER);
        while (hospital != null) {
            hospital = hospitals.getNext(BinarySearchTree.IN_ORDER);

            this.data.add(hospital);
        }

        //setup table
        table.setEditable(true);

        TableColumn nameCol = new TableColumn("Hospital Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Hospital, String>("name"));
        TableColumn addressCol = new TableColumn("Address");
        addressCol.setCellValueFactory(new PropertyValueFactory<Hospital, String>("address"));
        TableColumn locationCol = new TableColumn("Location");
        locationCol.setCellValueFactory(new PropertyValueFactory<Hospital, String>("location"));
        TableColumn phoneCol = new TableColumn("Phone");
        phoneCol.setCellValueFactory(new PropertyValueFactory<Hospital, String>("phone"));


        table.setItems(data);
        table.getColumns().addAll(nameCol, addressCol, locationCol, phoneCol);

    }

    /**
     * logout
     *
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
