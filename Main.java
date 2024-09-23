package org.example.ontap.jdbc2;


import org.example.ontap.jdbc2.model.Student;
import org.example.ontap.jdbc2.service.StudentService;

public class Main {
    static StudentService ssv = new StudentService();

    //    static Student student = new Student();
    public static Student studentUpdate() {
        Student s = new Student();
        s.setName_st("Khoa");
        s.setClazz("ABCD");
        s.setPhone("1234567890");
        return s;
    }

    public static Student studentInsert() {
        Student s = new Student();
        s.setId(15);
        s.setName_st("Pham");
        s.setClazz("ABC");
        s.setPhone("1234567890");
        return s;
    }

    public static void main(String[] args) {
//        ssv.selectStudents();
//        ssv.updateStudent(studentUpdate(), 15);
//        ssv.insertStudent(studentInsert());
        ssv.deleteStudent(17);
    }
}
