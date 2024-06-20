package dao;

import java.sql.*;

public class DBConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/biuro_turystyczne";
    private static final String USER = "root";
    private static final String PASSWORD = "Patrycja#02";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static ResultSet executeQuery(String query) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }
//    public static boolean addAdres(String ulica, String nrDomu, String nrMieszkania, String kodPocztowy, int idMiejscowosci) {
//        String query = "INSERT INTO adres (ulica, nr_domu, nr_mieszkania, kod_pocztowy, id_miejscowości) VALUES (?, ?, ?, ?, ?)";
//        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setString(1, ulica);
//            stmt.setString(2, nrDomu);
//            stmt.setString(3, nrMieszkania);
//            stmt.setString(4, kodPocztowy);
//            stmt.setInt(5, idMiejscowosci);
//            stmt.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public static void deleteAdres(int id) {
//        String query = "DELETE FROM adres WHERE id_adres = ?";
//        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setInt(1, id);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static ResultSet getAllAdres() {
//        String query = "SELECT * FROM adres";
//        try {
//            Connection conn = getConnection();
//            PreparedStatement stmt = conn.prepareStatement(query);
//            return stmt.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


}
