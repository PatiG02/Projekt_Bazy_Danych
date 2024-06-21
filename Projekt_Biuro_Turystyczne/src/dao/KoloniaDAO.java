package dao;

import model.Kolonia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KoloniaDAO {
    public List<Kolonia> getAllKolonia() {
        List<Kolonia> kolonias = new ArrayList<>();
        String query = "SELECT * FROM kolonia";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Kolonia kolonia = new Kolonia();
                kolonia.setIdKolonii(resultSet.getInt("id_kolonii"));
                kolonia.setIloscMiejsc(resultSet.getInt("ilość_miejsc"));
                kolonia.setDataRozpoczecia(resultSet.getDate("data_rozpoczęcia").toLocalDate());
                kolonia.setDataZakonczenia(resultSet.getDate("data_zakończenia").toLocalDate());
                kolonia.setCena(resultSet.getBigDecimal("cena"));
                kolonia.setIdMiejscowosci(resultSet.getInt("id_miejscowości"));
                kolonia.setIdZakwaterowania(resultSet.getInt("id_zakwaterowania"));
                kolonia.setIdAdres(resultSet.getInt("id_adres"));
                kolonias.add(kolonia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kolonias;
    }
}
