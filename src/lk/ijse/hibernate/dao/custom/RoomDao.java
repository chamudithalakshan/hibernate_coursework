package lk.ijse.hibernate.dao.custom;

import lk.ijse.hibernate.dao.CrudDAO;
import lk.ijse.hibernate.entity.Rooms;

import java.util.List;

public interface RoomDao extends CrudDAO<Rooms,String> {
List<Rooms> getRoomType();
List<Rooms> getRoomByType(String type);
}
