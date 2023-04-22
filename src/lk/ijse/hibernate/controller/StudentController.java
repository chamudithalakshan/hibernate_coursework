package lk.ijse.hibernate.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.bo.BoFactory;
import lk.ijse.hibernate.bo.custom.StudentBo;
import lk.ijse.hibernate.tdm.StudentTm;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    public TableView tbl;
    public TableColumn Sid;
    public TableColumn clmName;
    public TableColumn clmAddress;
    public TableColumn clmContact;
    public TableColumn clmGender;

    StudentBo studentBo = (StudentBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.STUDENT);


    public void tableInit() throws Exception {

        Sid.setCellValueFactory(new PropertyValueFactory<>("Student_id"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        clmContact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        clmGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        ObservableList<StudentTm> studentBoAll = studentBo.getAll();

        tbl.setItems(studentBoAll);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            tableInit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
