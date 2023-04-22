package lk.ijse.hibernate.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hibernate.bo.SuperBo;
import lk.ijse.hibernate.dto.StudentDto;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.tdm.StudentTm;

import java.util.List;

public interface StudentBo extends SuperBo {
    boolean saveStudent(StudentDto dto) throws Exception;

    List getLastId();

    ObservableList<String> getAllIds() throws Exception;

    List<Student> search(String id) throws Exception;

    void update(StudentDto studentDTO) throws Exception;

    ObservableList<StudentTm> getAll() throws Exception;
}
