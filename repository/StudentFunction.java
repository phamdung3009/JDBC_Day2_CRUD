package org.example.ontap.jdbc2.repository;

import org.example.ontap.jdbc2.model.Student;

public interface StudentFunction {
    public void selectStudents();
    public void insertStudent(Student student);
    public void updateStudent(Student student, int id);
    public void deleteStudent(int id);

}
