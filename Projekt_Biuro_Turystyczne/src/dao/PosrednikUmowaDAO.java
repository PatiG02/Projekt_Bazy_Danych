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
        String query = "SELECT u.id_umowy, u.nazwa AS umowa_nazwa, p.id_pośrednika, p.nazwa AS posrednik_nazwa, p.email, p.nr_telefonu, p.nip " +
                       "FROM umowa u " +
                       "JOIN pośrednik p ON u.id_pośrednika = p.id_pośrednika";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                PosrednikUmowa entry = new PosrednikUmowa();
                entry.setIdUmowy(resultSet.getInt("id_umowy"));
                entry.setUmowaNazwa(resultSet.getString("umowa_nazwa"));
                entry.setIdPosrednika(resultSet.getInt("id_pośrednika"));
                entry.setPosrednikNazwa(resultSet.getString("posrednik_nazwa"));
                entry.setEmail(resultSet.getString("email"));
                entry.setNrTelefonu(resultSet.getString("nr_telefonu"));
                entry.setNip(resultSet.getInt("nip"));
                reportEntries.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reportEntries;
    }
}
