package lk.ijse.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rooms {
    @Id
    private String Room_id;
    private String type;
    private String Key_money;
    private int Qty;

    @ManyToMany(mappedBy = "roomList", fetch = FetchType.EAGER)
    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Rooms() {
    }

    public Rooms(String room_id, String type, String key_money, int qty) {
        Room_id = room_id;
        this.type = type;
        Key_money = key_money;
        Qty = qty;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "Room_id='" + Room_id + '\'' +
                ", type='" + type + '\'' +
                ", Key_money='" + Key_money + '\'' +
                ", Qty=" + Qty +
                '}';
    }

    public String getRoom_id() {
        return Room_id;
    }

    public void setRoom_id(String room_id) {
        Room_id = room_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey_money() {
        return Key_money;
    }

    public void setKey_money(String key_money) {
        Key_money = key_money;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }
}
