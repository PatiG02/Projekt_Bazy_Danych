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
    private TableColumn<PosrednikUmowa, Integer> idUmowyColumn;
    @FXML
    private TableColumn<PosrednikUmowa, String> umowaNazwaColumn;
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

    private PosrednikUmowaDAO reportDAO = new PosrednikUmowaDAO();

    @FXML
    private void initialize() {
        idUmowyColumn.setCellValueFactory(new PropertyValueFactory<>("idUmowy"));
        umowaNazwaColumn.setCellValueFactory(new PropertyValueFactory<>("umowaNazwa"));
        idPosrednikaColumn.setCellValueFactory(new PropertyValueFactory<>("idPosrednika"));
        posrednikNazwaColumn.setCellValueFactory(new PropertyValueFactory<>("posrednikNazwa"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        nrTelefonuColumn.setCellValueFactory(new PropertyValueFactory<>("nrTelefonu"));
        nipColumn.setCellValueFactory(new PropertyValueFactory<>("nip"));

        ObservableList<PosrednikUmowa> reportList = FXCollections.observableArrayList(reportDAO.getPosrednikUmowaReport());
        reportTable.setItems(reportList);
    }
}
