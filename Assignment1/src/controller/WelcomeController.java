package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.*;
import utils.BinarySearchTree;
import view.HospitalShowJavaFXView;
import view.LoginJavaFXView;

/**
 * Welcome Screen Controller
 */
public class WelcomeController {

    public TableView table;
    public TextField searchbox;

    @FXML
    Label username;

    @FXML
    ImageView photo;

    private final ObservableList<Hospital> all_hospitals = FXCollections.observableArrayList();
    private final ObservableList<Hospital> filtered_hospitals = FXCollections.observableArrayList();

    /**
     * after initialize
     */
    public void initialize() throws Exception {
        User user = Session.getCurrentUser();

        username.setText(user.getUsername());

        if (!user.getPhoto().isEmpty()) photo.setImage(new Image("file:" + user.getPhoto()));

        this.loadHospitals();
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

    /**
     * Loads hospitals from excel document
     *
     * @throws Exception
     */
    private void loadHospitals() throws Exception {
        // Load hospitals
        BinarySearchTree<Hospital> hospitals = new HospitalDB().getList();

        hospitals.reset(BinarySearchTree.IN_ORDER);

        Hospital hospital;
        hospital = hospitals.getNext(BinarySearchTree.IN_ORDER);
        while (hospital != null) {
            this.all_hospitals.add(hospital);

            hospital = hospitals.getNext(BinarySearchTree.IN_ORDER);
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

        table.setItems(filtered_hospitals);
        table.getColumns().addAll(nameCol, addressCol, locationCol, phoneCol);

        this.resetFilteredList();
    }

    /**
     * Resets filter without any search terms
     */
    private void resetFilteredList() {
        this.resetFilteredList("");
    }

    /**
     * @param query String
     */
    private void resetFilteredList(String query) {
        this.filtered_hospitals.remove(0, this.filtered_hospitals.size());

        for (Hospital hospital : all_hospitals) {
            if (query.isEmpty() || this.searchHospital(hospital, query)) {
                this.filtered_hospitals.add(hospital);
            }
        }
    }

    /**
     * @param hospital Hospital
     * @param query    String
     * @return boolean
     */
    private boolean searchHospital(Hospital hospital, String query) {
        if (hospital == null) return false;
        return hospital.getName().contains(query)
                || hospital.getAddress().contains(query)
                || hospital.getPhone().contains(query)
                || Double.toString(hospital.getLocation().getLatitude()).indexOf(query) == 0
                || Double.toString(hospital.getLocation().getLongitude()).indexOf(query) == 0;
    }

    /**
     * @param event Event
     */
    public void updateSearch(Event event) {
        this.resetFilteredList(searchbox.getText());
    }

    public void showHospital(Event event) throws Exception {
        Hospital hospital = (Hospital)table.getSelectionModel().getSelectedItem();

        new HospitalShowJavaFXView(hospital);
    }
}
