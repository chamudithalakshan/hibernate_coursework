package lk.ijse.hibernate.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.hibernate.bo.SuperBo;
import lk.ijse.hibernate.bo.custom.StudentBo;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.StudentDao;
import lk.ijse.hibernate.dto.StudentDto;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.tdm.StudentTm;

import java.util.List;

public class StudentBOImpl implements StudentBo {
    StudentDao sDao = (StudentDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public boolean saveStudent(StudentDto dto) throws Exception {
        return sDao.add(new Student(dto.getStudent_id(),dto.getName(), dto.getAddress(), dto.getContact_no(), dto.getDob(), dto.getGender()));
    }

    @Override
    public List getLastId() {
        return null;
    }

    @Override
    public ObservableList<String> getAllIds() throws Exception {
        return null;
    }

    @Override
    public StudentDto search(String id) throws Exception {
        return null;
    }

    @Override
    public void update(StudentDto studentDTO) throws Exception {

    }

    @Override
    public ObservableList<StudentTm> getAll() throws Exception {
        return null;
    }
}
