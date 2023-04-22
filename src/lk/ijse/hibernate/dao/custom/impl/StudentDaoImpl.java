package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.FactoryConfiguration;
import lk.ijse.hibernate.dao.custom.StudentDao;
import lk.ijse.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class StudentDaoImpl implements StudentDao {


    @Override
    public boolean add(Student student) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Student student) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.update(student);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public List<Student> search(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Student r where r.Student_id= :Id");
        q.setParameter("Id", id);
        List results = q.getResultList();

        tx.commit();
        session.close();
        return results;
    }

    @Override
    public List<Student> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Student");
        System.out.println(q);
        List results = q.getResultList();

        tx.commit();
        session.close();
        return results;
    }

    @Override
    public List<Student> getAllId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Student");
        System.out.println(q);
        List results = q.getResultList();

        tx.commit();
        session.close();
        return results;
    }
}
