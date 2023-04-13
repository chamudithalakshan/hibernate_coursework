package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.hibernate.bo.BoFactory;
import lk.ijse.hibernate.bo.custom.StudentBo;
import lk.ijse.hibernate.dto.StudentDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class AddNewwStudentFormController {
    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField contactNmb;

    @FXML
    private JFXDatePicker dob;

    @FXML
    private JFXCheckBox male;

    @FXML
    private JFXCheckBox female;

    StudentBo studentBo = (StudentBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.STUDENT);

    @FXML
    void AddOnAction(ActionEvent event) throws Exception {
        String idText = id.getText();
        String nameText = name.getText();
        String addressText = address.getText();
        String nmbText = contactNmb.getText();
        LocalDate date = dob.getValue();
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date.toString());
        StudentDto studentDto = new StudentDto(idText, nameText, addressText, nmbText, date1, "male");
        if (studentBo.saveStudent(studentDto)) dob.getScene().getWindow().hide();
    }
}
