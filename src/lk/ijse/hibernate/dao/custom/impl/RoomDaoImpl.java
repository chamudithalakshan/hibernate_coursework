package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.FactoryConfiguration;
import lk.ijse.hibernate.dao.custom.RoomDao;
import lk.ijse.hibernate.entity.Rooms;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    @Override
    public boolean add(Rooms rooms) throws Exception {
        System.out.println(rooms);
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.save(rooms);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Rooms rooms) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.update(rooms);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public List<Rooms> search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Rooms> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Rooms");
        System.out.println(q);
        List results = q.getResultList();
        tx.commit();
        session.close();
        return results;
    }

    @Override
    public List<Rooms> getRoomType() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Rooms");
        System.out.println(q);
        List results = q.getResultList();

        tx.commit();
        session.close();
        return results;
    }

    @Override
    public List<Rooms> getRoomByType(String type) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Rooms r where r.type= :type");
        q.setParameter("type", type);
        System.out.println(q);
        List results = q.getResultList();

        tx.commit();
        session.close();
        return results;
    }


}

