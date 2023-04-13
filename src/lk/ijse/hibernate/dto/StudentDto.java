package lk.ijse.hibernate.dto;

import java.util.Date;

public class StudentDto {
    private String Student_id;
    private String Name;
    private String Address;
    private String Contact_no;
    private Date Dob;
    private String Gender;

    public StudentDto(String student_id, String name, String address, String contact_no, Date dob, String gender) {
        Student_id = student_id;
        Name = name;
        Address = address;
        Contact_no = contact_no;
        Dob = dob;
        Gender = gender;
    }

    public StudentDto() {
    }

    public String getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(String student_id) {
        Student_id = student_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact_no() {
        return Contact_no;
    }

    public void setContact_no(String contact_no) {
        Contact_no = contact_no;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date dob) {
        Dob = dob;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "Student_id='" + Student_id + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Contact_no='" + Contact_no + '\'' +
                ", Dob=" + Dob +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
