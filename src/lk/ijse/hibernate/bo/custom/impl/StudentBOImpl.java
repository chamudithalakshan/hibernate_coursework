package lk.ijse.hibernate.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hibernate.bo.custom.StudentBo;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.StudentDao;
import lk.ijse.hibernate.dto.RoomDto;
import lk.ijse.hibernate.dto.StudentDto;
import lk.ijse.hibernate.entity.Rooms;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.tdm.StudentTm;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBo {
    StudentDao sDao = (StudentDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean saveStudent(StudentDto dto) throws Exception {
        return sDao.add(new Student(dto.getStudent_id(), dto.getName(), dto.getAddress(), dto.getContact_no(), dto.getDob(), dto.getGender()));
    }

    @Override
    public List getLastId() {
        return null;
    }

    @Override
    public ObservableList<String> getAllIds() throws Exception {
        List<Student> allId = sDao.getAllId();
        if (allId != null) {
            ObservableList<String> obs = FXCollections.observableArrayList();
            for (Student s :
                    allId) {
                obs.add(s.getStudent_id());
            }
            System.out.println(obs);
            return obs;
        }
        return null;
    }

    @Override
    public List<Student> search(String id) throws Exception {
        return sDao.search(id);
    }

    @Override
    public void update(StudentDto studentDTO) throws Exception {
        List<RoomDto> roomList = studentDTO.getRoomList();
        List<Rooms> list = new ArrayList<>();
        for (RoomDto room : roomList) {
            list.add(new Rooms(room.getRoom_id(), room.getType(), room.getKey_money(), room.getQty()));
        }
        sDao.update(new Student(studentDTO.getStudent_id(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getContact_no(), studentDTO.getDob(), studentDTO.getGender(), studentDTO.getPaymentStatus(), list));
    }

    @Override
    public ObservableList<StudentTm> getAll() throws Exception {
        ObservableList<StudentTm> obs = FXCollections.observableArrayList();
        List<Student> all = sDao.getAll();
        System.out.println(all);
        for (Student s : all) {
            if(!s.getRoomList().isEmpty()) {
                for (Rooms r : s.getRoomList()) {
                    obs.add(new StudentTm(
                            s.getStudent_id(),
                            s.getName(),
                            s.getContact_no(),
                            s.getGender(),
                            s.getAddress(),
                            r.getType(),
                            s.getPaidStatus()
                    ));
                }
            }
        }
        return obs;
    }
}
