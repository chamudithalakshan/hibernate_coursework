package lk.ijse.hibernate.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hibernate.bo.SuperBo;
import lk.ijse.hibernate.dto.RoomDto;
import lk.ijse.hibernate.entity.Rooms;
import lk.ijse.hibernate.tdm.RoomTm;

import java.util.List;

public interface RoomBo extends SuperBo {
    ObservableList<RoomTm> getAllRooms() throws Exception;

    boolean save(RoomDto dto) throws Exception;
    boolean update(RoomDto dto) throws Exception;

    RoomDto search(String id) throws Exception;

    ObservableList<String> getRoomTypes();

    List<Rooms>getRoomByType(String type);
}
