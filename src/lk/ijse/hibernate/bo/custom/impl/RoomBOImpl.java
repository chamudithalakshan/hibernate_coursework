package lk.ijse.hibernate.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hibernate.bo.custom.RoomBo;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.RoomDao;
import lk.ijse.hibernate.dto.RoomDto;
import lk.ijse.hibernate.entity.Rooms;
import lk.ijse.hibernate.tdm.RoomTm;

import java.util.List;

public class RoomBOImpl implements RoomBo {
    RoomDao sDao = (RoomDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public ObservableList<RoomTm> getAllRooms() throws Exception {
        List<Rooms> all = sDao.getAll();
        ObservableList<RoomTm> tm = FXCollections.observableArrayList();
        for (Rooms r:
             all) {
            tm.add(new RoomTm(r.getRoom_id(),r.getType(),r.getKey_money(),r.getQty()));
        }
        return tm;
    }

    @Override
    public boolean save(RoomDto dto) throws Exception {
        if (dto != null){
            return sDao.add(new Rooms(dto.getRoom_id(), dto.getType(), dto.getKey_money(), dto.getQty()));
        }
        return false;
    }

    @Override
    public boolean update(RoomDto dto) throws Exception {
        return sDao.update(new Rooms(dto.getRoom_id(), dto.getType(), dto.getKey_money(), dto.getQty()));
    }

    @Override
    public RoomDto search(String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<String> getRoomTypes() {
        List<Rooms> roomType = sDao.getRoomType();
        if (roomType != null) {
            ObservableList<String> obs = FXCollections.observableArrayList();
            for (Rooms r :
                    roomType) {
                obs.add(r.getType());
            }
            System.out.println(obs);
            return obs;
        }
        return null;    }

    @Override
    public List<Rooms> getRoomByType(String type) {
        return sDao.getRoomByType(type);
    }
}
