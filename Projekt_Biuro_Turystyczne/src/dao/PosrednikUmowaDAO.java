package dao;

import model.PosrednikUmowa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PosrednikUmowaDAO {
    public List<PosrednikUmowa> getPosrednikUmowaReport() {
        List<PosrednikUmowa> reportEntries = new ArrayList<>();
        String query = "SELECT p.id_pośrednika, p.nazwa AS posrednik_nazwa, p.email, p.nr_telefonu, p.nip, COUNT(u.id_umowy) AS umowa_count " +
                       "FROM pośrednik p " +
                       "LEFT JOIN umowa u ON u.id_pośrednika = p.id_pośrednika " +
                       "GROUP BY p.id_pośrednika, p.nazwa, p.email, p.nr_telefonu, p.nip";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                PosrednikUmowa entry = new PosrednikUmowa();
                entry.setIdPosrednika(resultSet.getInt("id_pośrednika"));
                entry.setPosrednikNazwa(resultSet.getString("posrednik_nazwa"));
                entry.setEmail(resultSet.getString("email"));
                entry.setNrTelefonu(resultSet.getString("nr_telefonu"));
                entry.setNip(resultSet.getInt("nip"));
                entry.setUmowaCount(resultSet.getInt("umowa_count"));
                reportEntries.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reportEntries;
    }
}
