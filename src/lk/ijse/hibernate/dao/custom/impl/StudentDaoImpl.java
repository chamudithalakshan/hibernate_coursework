package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.FactoryConfiguration;
import lk.ijse.hibernate.dao.custom.StudentDao;
import lk.ijse.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDaoImpl implements StudentDao {


    @Override
    public boolean add(Student student) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
        return true;    }

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
