package lk.ijse.hibernate.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.hibernate.bo.SuperBo;
import lk.ijse.hibernate.bo.custom.RoomBo;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.RoomDao;
import lk.ijse.hibernate.dao.custom.StudentDao;
import lk.ijse.hibernate.dto.RoomDto;
import lk.ijse.hibernate.entity.Rooms;
import lk.ijse.hibernate.entity.Student;

import java.util.List;

public class RoomBOImpl implements RoomBo {
    RoomDao sDao = (RoomDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public ObservableList<String> getAllRooms() throws Exception {
        return null;
    }

    @Override
    public boolean save(RoomDto dto) throws Exception {
        if (dto != null){
            return sDao.add(new Rooms(dto.getRoom_id(), dto.getType(), dto.getKey_money(), dto.getQty()));
        }
        return false;
    }

    @Override
    public RoomDto search(String id) throws Exception {
        return null;
    }

    @Override
    public List<String> getRoomTypes() {
        return null;
    }
}
