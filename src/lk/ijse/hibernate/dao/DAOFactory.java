package lk.ijse.hibernate.dao;

import lk.ijse.hibernate.dao.custom.impl.RoomDaoImpl;
import lk.ijse.hibernate.dao.custom.impl.StudentDaoImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
            return daoFactory;
        }
        return daoFactory;
    }

    //factory method
    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDaoImpl();
            case ROOM:
                return new RoomDaoImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        STUDENT, ROOM
    }
}
