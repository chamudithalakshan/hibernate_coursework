package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.FactoryConfiguration;
import lk.ijse.hibernate.dao.custom.RoomDao;
import lk.ijse.hibernate.entity.Rooms;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        return false;
    }

    @Override
    public Rooms search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Rooms> getAll() throws Exception {
        return null;
    }
}
