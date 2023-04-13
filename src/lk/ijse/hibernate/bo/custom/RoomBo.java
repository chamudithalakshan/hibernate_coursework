package lk.ijse.hibernate.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hibernate.bo.SuperBo;
import lk.ijse.hibernate.dto.RoomDto;

import java.util.List;

public interface RoomBo extends SuperBo {
    ObservableList<String> getAllRooms() throws Exception;

    boolean save(RoomDto dto) throws Exception;

    RoomDto search(String id) throws Exception;

    List<String> getRoomTypes();
}
