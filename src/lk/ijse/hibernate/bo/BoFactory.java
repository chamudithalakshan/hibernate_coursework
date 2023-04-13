package lk.ijse.hibernate.bo;

import lk.ijse.hibernate.bo.custom.impl.RoomBOImpl;
import lk.ijse.hibernate.bo.custom.impl.StudentBOImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BoFactory();
            return boFactory;
        }
        return boFactory;
    }

    //factory method
    public SuperBo getBO(BoFactory.BOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentBOImpl();
            case ROOMS:
                return new RoomBOImpl();
            default:
                return null;
        }
    }

    public enum BOTypes {
        STUDENT, ROOMS
    }
}
