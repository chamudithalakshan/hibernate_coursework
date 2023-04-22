package lk.ijse.hibernate.tdm;

import lk.ijse.hibernate.entity.Rooms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentTm {
        private String Student_id;



    private String studentName;
    private String contactNo;

    private String gender;

    private String Address;

    private List<Rooms> roomList = new ArrayList<>();

    private String paymentStatus;

    private String RoomType;

    public StudentTm(String student_id, String studentName, String contactNo, String gender, String address,String RoomType, String paymentStatus) {
        Student_id = student_id;
        this.studentName = studentName;
        this.contactNo = contactNo;
        this.gender = gender;
        Address = address;
        this.RoomType = RoomType;
        this.paymentStatus = paymentStatus;
    }

    public StudentTm(String student_id, String studentName, String contactNo, String gender, String address, String paymentStatus) {
        Student_id = student_id;
        this.studentName = studentName;
        this.contactNo = contactNo;
        this.gender = gender;
        Address = address;
        this.paymentStatus = paymentStatus;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public List<Rooms> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Rooms> roomList) {
        this.roomList = roomList;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public StudentTm() {
    }

    public String getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(String student_id) {
        Student_id = student_id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "StudentTm{" +
                "Student_id='" + Student_id + '\'' +
                ", studentName='" + studentName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", gender='" + gender + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
