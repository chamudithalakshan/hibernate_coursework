package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.StudentDao;
import lk.ijse.hibernate.entity.Student;

import java.util.List;

public class StudentDaoImpl implements StudentDao {


    @Override
    public boolean add(Student student) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Student student) throws Exception {
        return false;
    }

    @Override
    public Student search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Student> getAll() throws Exception {
        return null;
    }
}
