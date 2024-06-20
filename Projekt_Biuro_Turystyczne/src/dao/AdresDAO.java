package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import model.Adres;

public class AdresDAO {
	public Adres getAdresById(int idAdres) {
		Adres adres = null;
		String query = "SELECT * FROM Adres WHERE id_adres = ?";
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement statement = conn.prepareStatement(query)) {
				statement.setInt(1, idAdres);
				ResultSet resultSet = statement.executeQuery();

				if (resultSet.next()) {
					adres = new Adres();
					adres.setIdAdres(new SimpleIntegerProperty(resultSet.getInt("id_adres")));
					adres.setUlica(new SimpleStringProperty(resultSet.getString("ulica")));
					adres.setNrDomu(new SimpleStringProperty(resultSet.getString("nr_domu")));
					adres.setNrMieszkania(new SimpleIntegerProperty(resultSet.getInt("nr_mieszkania")));
					adres.setKodPocztowy(new SimpleStringProperty(resultSet.getString("kod_pocztowy")));
					adres.setIdMiejscowosci(new SimpleIntegerProperty(resultSet.getInt("id_miejscowości")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return adres;
	}
    public static boolean addAdres(String ulica, String nrDomu, String nrMieszkania, String kodPocztowy, int idMiejscowosci) {
        String query = "INSERT INTO adres (ulica, nr_domu, nr_mieszkania, kod_pocztowy, id_miejscowości) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, ulica);
            stmt.setString(2, nrDomu);
            stmt.setString(3, nrMieszkania);
            stmt.setString(4, kodPocztowy);
            stmt.setInt(5, idMiejscowosci);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void deleteAdres(int id) {
        String query = "DELETE FROM adres WHERE id_adres = ?";
        try (Connection conn = DBConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getAllAdres() {
        String query = "SELECT * FROM adres";
        try {
            Connection conn = DBConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
