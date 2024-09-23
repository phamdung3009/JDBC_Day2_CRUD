package org.example.ontap.jdbc2.service;

import org.example.ontap.jdbc2.connection.ConnectionDatabase;
import org.example.ontap.jdbc2.connection.InfoDatabase;
import org.example.ontap.jdbc2.model.Student;
import org.example.ontap.jdbc2.repository.StudentFunction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentService implements StudentFunction {
    private static ConnectionDatabase conDb = new ConnectionDatabase();
    private static InfoDatabase info = new InfoDatabase();
    private static final String SELECT_ALL_STUDENT = "SELECT * FROM student;";
    private static final String UPDATE_STUDENT = "UPDATE student SET name_st = ?, clazz = ?, phone = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM student WHERE id = ?";
    private static final String INSER_INTO = "INSERT INTO student (id,name_st,clazz,phone) VALUES (?, ?, ?, ?)";

    @Override
    public void selectStudents() {
        try {
            Connection con = conDb.getConnection(info.DB_URL, info.USER, info.PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_STUDENT);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName_st(rs.getString(2));
                student.setClazz(rs.getString(3));
                student.setPhone(rs.getString(4));
                System.out.println(student);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertStudent(Student student) {
        try {
            Connection con = conDb.getConnection(info.DB_URL, info.USER, info.PASS);
            PreparedStatement p = con.prepareStatement(INSER_INTO);
            p.setInt(1, student.getId());
            p.setString(2, student.getName_st());
            p.setString(3, student.getClazz());
            p.setString(4, student.getPhone());
            int checkResultUpdate = p.executeUpdate();
            if (checkResultUpdate > 0) {
                System.out.println("INSERT SUCCESS!");
            } else {
                System.out.println("INSERT FAILED!");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student, int id) {
        try {
            Connection con = conDb.getConnection(info.DB_URL, info.USER, info.PASS);
            PreparedStatement pre = con.prepareStatement(UPDATE_STUDENT);
            pre.setString(1, student.getName_st());
            pre.setString(2, student.getClazz());
            pre.setString(3, student.getPhone());
            pre.setInt(4, id);
            int checkResultUpdate = pre.executeUpdate();
            if (checkResultUpdate > 0) {
                System.out.println("UPDATE SUCCESS!");
            } else {
                System.out.println("UPDATE FAILED!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        try {
            Connection con = conDb.getConnection(info.DB_URL, info.USER, info.PASS);
            PreparedStatement pre = con.prepareStatement(DELETE_BY_ID);
            pre.setInt(1, id);
            int checkResultDeleted = pre.executeUpdate();
            if (checkResultDeleted == 1) {
                System.out.println("DELETE SUCCESS!");
            } else {
                System.out.println("DELETE FAILED!");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
