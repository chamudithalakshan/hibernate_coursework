package lk.ijse.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FunctionFormController implements Initializable {
    public BorderPane borderPane;

    public void MAkeRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        borderPane.setCenter(FXMLLoader.load(getClass().getResource("../view/ReservationForm.fxml")));    }

    public void manageRoomsOnAction(ActionEvent actionEvent) throws IOException {
        borderPane.setCenter(FXMLLoader.load(getClass().getResource("../view/ManageRoom.fxml")));
    }

    public void findRemainingKeyMoney(ActionEvent actionEvent) throws IOException {
        borderPane.setCenter(FXMLLoader.load(getClass().getResource("../view/RemainingKeyMoney.fxml")));
    }

    public void studentsOnAction(ActionEvent actionEvent) throws IOException {
        borderPane.setCenter(FXMLLoader.load(getClass().getResource("../view/Student.fxml")));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            borderPane.setCenter(FXMLLoader.load(getClass().getResource("../view/ReservationForm.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
