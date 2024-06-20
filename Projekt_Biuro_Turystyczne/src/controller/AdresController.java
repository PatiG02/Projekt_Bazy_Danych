package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Adres;
import report.AdresReportFile;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AdresDAO;
import dao.DBConnector;

public class AdresController {
    @FXML
    private TableView<Adres> adresTable;
    @FXML
    private TableColumn<Adres, Integer> idColumn;
    @FXML
    private TableColumn<Adres, String> ulicaColumn;
    @FXML
    private TableColumn<Adres, String> nrDomuColumn;
    @FXML
    private TableColumn<Adres, Integer> nrMieszkaniaColumn;
    @FXML
    private TableColumn<Adres, String> kodPocztowyColumn;
    @FXML
    private TableColumn<Adres, Integer> idMiejscowosciColumn;

    @FXML
    private TextField ulicaField;
    @FXML
    private TextField nrDomuField;
    @FXML
    private TextField nrMieszkaniaField;
    @FXML
    private TextField kodPocztowyField;
    @FXML
    private ComboBox<Integer> idMiejscowosciComboBox;

    private ObservableList<Adres> adresData = FXCollections.observableArrayList();
    private ObservableList<Integer> miejscowosciData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idAdresProperty().asObject());
        ulicaColumn.setCellValueFactory(cellData -> cellData.getValue().ulicaProperty());
        nrDomuColumn.setCellValueFactory(cellData -> cellData.getValue().nrDomuProperty());
        nrMieszkaniaColumn.setCellValueFactory(cellData -> cellData.getValue().nrMieszkaniaProperty().asObject());
        kodPocztowyColumn.setCellValueFactory(cellData -> cellData.getValue().kodPocztowyProperty());
        idMiejscowosciColumn.setCellValueFactory(cellData -> cellData.getValue().idMiejscowosciProperty().asObject());

        loadAdresData();
        loadMiejscowosciData();
    }

    @FXML
    private void handleAdd() {
//    	boolean errorOccurred = false;
		try{
	        String ulica = ulicaField.getText();
	        String nrDomu = nrDomuField.getText();
	        String nrMieszkania = nrMieszkaniaField.getText().isEmpty() ? null : nrMieszkaniaField.getText();
	        String kodPocztowy = kodPocztowyField.getText();
	        int idMiejscowosci = idMiejscowosciComboBox.getValue();
	        if (AdresDAO.addAdres(ulica, nrDomu, nrMieszkania, kodPocztowy, idMiejscowosci)) {
        		showAlert(AlertType.INFORMATION, "Success", "Address added successfully!");	
	        }
	        else {
	        	showAlert(AlertType.ERROR, "Error", "Address has not been added to DB!");
	        }
		}catch(Exception e){
			e.printStackTrace();
			showAlert(AlertType.ERROR, "javafx errror", "Data validation error!");
//			errorOccurred = true;
		}        
        loadAdresData();
    }

	
//        String ulica = ulicaField.getText();
//        String nrDomu = nrDomuField.getText();
//        String nrMieszkania = nrMieszkaniaField.getText().isEmpty() ? null : nrMieszkaniaField.getText();
//        String kodPocztowy = kodPocztowyField.getText();
//        int idMiejscowosci = idMiejscowosciComboBox.getValue();

//        if (DatabaseHandler.addAdres(ulica, nrDomu, nrMieszkania, kodPocztowy, idMiejscowosci)) {
//        	showAlert(AlertType.INFORMATION, "Success", "Address added successfully!");	
//        }
//        else {
//        	showAlert(AlertType.ERROR, "Error", "Address has not been added to DB!");
//        }
//        loadAdresData();
//    }

    @FXML
    private void handleDelete() {
        Adres selectedAdres = adresTable.getSelectionModel().getSelectedItem();
        if (selectedAdres != null) {
            AdresDAO.deleteAdres(selectedAdres.getIdAdres());
            showAlert(AlertType.INFORMATION, "Success", "Address deleted successfully!");
            loadAdresData();
        } else {
            showAlert(AlertType.WARNING, "No Selection", "Please select an address to delete.");
        }
    }
    
    @FXML
    private void handleSaveToDisk() {
    	try {
    		AdresReportFile.saveAdresList();
    	}catch(IOException e) {
    		e.printStackTrace();
    		showAlert(AlertType.ERROR, "Error", "Report can not be saved!");
    	}
    }

    private void loadAdresData() {
        adresData.clear();
        ResultSet rs = AdresDAO.getAllAdres();
        try {
            while (rs.next()) {
                Adres adres = new Adres(
                    rs.getInt("id_adres"),
                    rs.getString("ulica"),
                    rs.getString("nr_domu"),
                    rs.getInt("nr_mieszkania"),
                    rs.getString("kod_pocztowy"),
                    rs.getInt("id_miejscowości")
                );
                adresData.add(adres);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        adresTable.setItems(adresData);
    }

    private void loadMiejscowosciData() {
        miejscowosciData.clear();
        String query = "SELECT id_miejscowości FROM miejscowość";
        try (ResultSet rs = DBConnector.executeQuery(query)) {
            while (rs.next()) {
                miejscowosciData.add(rs.getInt("id_miejscowości"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        idMiejscowosciComboBox.setItems(miejscowosciData);
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
