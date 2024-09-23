package org.example.ontap.jdbc2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
    public static Connection getConnection(String DB_URL, String USER, String PASS) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
