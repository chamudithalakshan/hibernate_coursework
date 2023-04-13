package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.hibernate.bo.BoFactory;
import lk.ijse.hibernate.bo.custom.RoomBo;
import lk.ijse.hibernate.bo.custom.StudentBo;

import java.io.IOException;

public class ReservationFormController {
    public TableView tblReservation;
    public JFXComboBox cmbRoomType;
    public JFXComboBox cmbStudentId;
    public Label lblKeymoney;
    public Label lblRoomQty;
    public CheckBox chkPaid;
    public CheckBox chkNonPaid;

StudentBo studentBo= (StudentBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.STUDENT);
RoomBo bo = (RoomBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.ROOMS);

    public void addStudentOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/hibernate/view/AddNewStudentForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public void makeReservationOnAction(ActionEvent actionEvent) {

    }
    public void loadRoomType(){
cmbRoomType.setItems((ObservableList) bo.getRoomTypes());
    }

    public void loadStudentId() throws Exception {
        cmbStudentId.setItems(studentBo.getAllIds());
    }
}
