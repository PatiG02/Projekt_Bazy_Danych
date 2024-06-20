package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectorOld {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Patrycja#02";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/biuro_turystyczne";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }
}
