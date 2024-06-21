package controller;

import dao.PosrednikUmowaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.PosrednikUmowa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PosrednikUmowaReportController {
    @FXML
    private TableView<PosrednikUmowa> reportTable;
    @FXML
    private TableColumn<PosrednikUmowa, Integer> idPosrednikaColumn;
    @FXML
    private TableColumn<PosrednikUmowa, String> posrednikNazwaColumn;
    @FXML
    private TableColumn<PosrednikUmowa, String> emailColumn;
    @FXML
    private TableColumn<PosrednikUmowa, String> nrTelefonuColumn;
    @FXML
    private TableColumn<PosrednikUmowa, Integer> nipColumn;
    @FXML
    private TableColumn<PosrednikUmowa, Integer> umowaCountColumn; // New column for umowa count

    private PosrednikUmowaDAO reportDAO = new PosrednikUmowaDAO();

    @FXML
    private void initialize() {
        idPosrednikaColumn.setCellValueFactory(new PropertyValueFactory<>("idPosrednika"));
        posrednikNazwaColumn.setCellValueFactory(new PropertyValueFactory<>("posrednikNazwa"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        nrTelefonuColumn.setCellValueFactory(new PropertyValueFactory<>("nrTelefonu"));
        nipColumn.setCellValueFactory(new PropertyValueFactory<>("nip"));
        umowaCountColumn.setCellValueFactory(new PropertyValueFactory<>("umowaCount"));

        ObservableList<PosrednikUmowa> reportList = FXCollections.observableArrayList(reportDAO.getPosrednikUmowaReport());
        reportTable.setItems(reportList);
    }
}
