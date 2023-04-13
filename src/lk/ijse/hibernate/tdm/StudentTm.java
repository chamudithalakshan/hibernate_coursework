package lk.ijse.hibernate.tdm;

public class StudentTm {
    private String Student_id;
    private String studentName;
    private String contactNo;
    private int age;
    private String gender;

    private String Address;

    public StudentTm(String student_id, String studentName, String contactNo, int age, String gender, String address) {
        Student_id = student_id;
        this.studentName = studentName;
        this.contactNo = contactNo;
        this.age = age;
        this.gender = gender;
        Address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
