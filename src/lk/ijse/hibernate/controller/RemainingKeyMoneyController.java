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

public class RemainingKeyMoneyController implements Initializable {
    public TableColumn Sid;
    public TableColumn clmName;
    public TableColumn clmAddress;
    public TableColumn clmContact;
    public TableColumn clmGender;
    public TableView tbl;
    StudentBo studentBo = (StudentBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.STUDENT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            tableInit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void tableInit() throws Exception {

        Sid.setCellValueFactory(new PropertyValueFactory<>("Student_id"));
clmName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
clmAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
clmContact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
clmGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        ObservableList<StudentTm> studentBoAll = studentBo.getAll();
        ObservableList<StudentTm> all= FXCollections.observableArrayList();
        for (StudentTm tm:
             studentBoAll) {
           if (tm.getPaymentStatus().equals("Non-Paid")){
               all.add(tm);
           }
        }
        tbl.setItems(all);

    }
}
