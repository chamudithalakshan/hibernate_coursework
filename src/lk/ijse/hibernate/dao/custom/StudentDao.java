package lk.ijse.hibernate.dao.custom;


import lk.ijse.hibernate.dao.CrudDAO;
import lk.ijse.hibernate.entity.Student;

import java.util.List;

public interface StudentDao extends CrudDAO<Student,String> {
   List<Student> getAllId();

}
