package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.hibernate.bo.BoFactory;
import lk.ijse.hibernate.bo.custom.RoomBo;
import lk.ijse.hibernate.bo.custom.StudentBo;
import lk.ijse.hibernate.dto.RoomDto;
import lk.ijse.hibernate.dto.StudentDto;
import lk.ijse.hibernate.entity.Rooms;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.tdm.StudentTm;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {
    public TableView tblReservation;
    public JFXComboBox cmbRoomType;
    public JFXComboBox<String> cmbStudentId;
    public Label lblKeymoney;
    public Label lblRoomQty;
    public CheckBox chkPaid;
    public CheckBox chkNonPaid;
    public TableColumn clmStudentId;
    public TableColumn clmName;
    public TableColumn clmRoomType;
    public TableColumn clmStatus;

    StudentBo studentBo = (StudentBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.STUDENT);
    RoomBo bo = (RoomBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.ROOMS);

    public void addStudentOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/hibernate/view/AddNewStudentForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public void makeReservationOnAction(ActionEvent actionEvent) throws Exception {
        String selectedItem = (String) cmbRoomType.getSelectionModel().getSelectedItem();
        List<Rooms> roomByType = bo.getRoomByType(selectedItem);
        Rooms rooms = roomByType.get(0);
        List<Student> search = studentBo.search((String) cmbStudentId.getSelectionModel().getSelectedItem());
        Student student = search.get(0);
        StudentDto studentDto = new StudentDto();
        studentDto.setStudent_id(student.getStudent_id());
        studentDto.setName(student.getName());
        studentDto.setAddress(student.getAddress());
        studentDto.setContact_no(student.getContact_no());
        studentDto.setDob(student.getDob());
        studentDto.setGender(student.getGender());
        List<RoomDto> roomList = studentDto.getRoomList();
        studentDto.setPaymentStatus(chkPaid.isSelected() ? "Paid" : "Non-Paid");
        roomList.add(new RoomDto(rooms.getRoom_id(), rooms.getType(), rooms.getKey_money(), rooms.getQty()));
        studentDto.setRoomList(roomList);
        studentBo.update(studentDto);
        bo.update(new RoomDto(rooms.getRoom_id(), rooms.getType(), rooms.getKey_money(), rooms.getQty()-1));
        tableInit();
    }

    public void loadRoomType() {
        cmbRoomType.setItems((ObservableList) bo.getRoomTypes());
    }

    public void loadStudentId() throws Exception {
        ObservableList<String> allIds = studentBo.getAllIds();
        if (allIds != null) {
            cmbStudentId.setItems(studentBo.getAllIds());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadStudentId();
            loadRoomType();
            tableInit();
//            selectedCheckBox();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public void roomTypeOnAction(ActionEvent actionEvent) {
        String selectedItem = (String) cmbRoomType.getSelectionModel().getSelectedItem();
        List<Rooms> roomByType = bo.getRoomByType(selectedItem);
        Rooms rooms = roomByType.get(0);
        lblKeymoney.setText(rooms.getKey_money());
        lblRoomQty.setText(String.valueOf(rooms.getQty()));
    }

    public void tableInit() throws Exception {
        clmStudentId.setCellValueFactory(new PropertyValueFactory<>("Student_id"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        clmStatus.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
        clmRoomType.setCellValueFactory(new PropertyValueFactory<>("RoomType"));

        ObservableList<StudentTm> all = studentBo.getAll();

        tblReservation.setItems(all);
    }

    public void onSelectPaid(ActionEvent actionEvent) {
        chkNonPaid.setSelected(false);
    }

    public void onSelectNonPaid(ActionEvent actionEvent) {
        chkPaid.setSelected(false);
    }
}
