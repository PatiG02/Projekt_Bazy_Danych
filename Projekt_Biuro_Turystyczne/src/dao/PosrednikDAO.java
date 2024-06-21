package dao;

import model.Posrednik;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PosrednikDAO {
    public List<Posrednik> getAllPosrednik() {
        List<Posrednik> posrednicy = new ArrayList<>();
        String query = "SELECT * FROM pośrednik";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Posrednik posrednik = new Posrednik();
                posrednik.setIdPosrednika(resultSet.getInt("id_pośrednika"));
                posrednik.setNazwa(resultSet.getString("nazwa"));
                posrednik.setEmail(resultSet.getString("email"));
                posrednik.setNrTelefonu(resultSet.getString("nr_telefonu"));
                posrednik.setNip(resultSet.getInt("nip"));
                posrednik.setIdAdres(resultSet.getInt("id_adres"));
                posrednicy.add(posrednik);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posrednicy;
    }
}
