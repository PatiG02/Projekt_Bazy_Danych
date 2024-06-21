package dao;

import model.Umowa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UmowaDAO {
    public List<Umowa> getAllUmowy() {
        List<Umowa> umowy = new ArrayList<>();
        String query = "SELECT * FROM umowa";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Umowa umowa = new Umowa();
                umowa.setIdUmowy(resultSet.getInt("id_umowy"));
                umowa.setNazwa(resultSet.getString("nazwa"));
                umowa.setIdPosrednika(resultSet.getInt("id_pośrednika"));
                umowa.setIdKolonii(resultSet.getInt("id_kolonii"));
                umowa.setIdOsoba(resultSet.getInt("id_osoba"));
                umowa.setIdTransportu(resultSet.getInt("id_transportu"));
                umowa.setIdWyzywienia(resultSet.getInt("id_wyżywienia"));
                umowy.add(umowa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return umowy;
    }
}
