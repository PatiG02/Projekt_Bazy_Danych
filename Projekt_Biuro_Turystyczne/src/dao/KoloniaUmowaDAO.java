package dao;

import model.KoloniaUmowa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KoloniaUmowaDAO {
    public List<KoloniaUmowa> getKoloniaUmowaReport() {
        List<KoloniaUmowa> reportEntries = new ArrayList<>();
        String query = "SELECT u.id_umowy, u.nazwa AS umowa_nazwa, k.id_kolonii, k.ilość_miejsc, k.data_rozpoczęcia, k.data_zakończenia, k.cena " +
                       "FROM umowa u " +
                       "JOIN kolonia k ON u.id_kolonii = k.id_kolonii";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                KoloniaUmowa entry = new KoloniaUmowa();
                entry.setIdUmowy(resultSet.getInt("id_umowy"));
                entry.setUmowaNazwa(resultSet.getString("umowa_nazwa"));
                entry.setIdKolonii(resultSet.getInt("id_kolonii"));
                entry.setIloscMiejsc(resultSet.getInt("ilość_miejsc"));
                entry.setDataRozpoczecia(resultSet.getDate("data_rozpoczęcia").toLocalDate());
                entry.setDataZakonczenia(resultSet.getDate("data_zakończenia").toLocalDate());
                entry.setCena(resultSet.getBigDecimal("cena"));
                reportEntries.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reportEntries;
    }
}
