package controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import dao.KoloniaUmowaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.KoloniaUmowa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KoloniaUmowaReportController {
    @FXML
    private TableView<KoloniaUmowa> reportTable;
    @FXML
    private TableColumn<KoloniaUmowa, Integer> idUmowyColumn;
    @FXML
    private TableColumn<KoloniaUmowa, String> umowaNazwaColumn;
    @FXML
    private TableColumn<KoloniaUmowa, Integer> idKoloniiColumn;
    @FXML
    private TableColumn<KoloniaUmowa, Integer> iloscMiejscColumn;
    @FXML
    private TableColumn<KoloniaUmowa, LocalDate> dataRozpoczeciaColumn;
    @FXML
    private TableColumn<KoloniaUmowa, LocalDate> dataZakonczeniaColumn;
    @FXML
    private TableColumn<KoloniaUmowa, BigDecimal> cenaColumn;

    private KoloniaUmowaDAO reportDAO = new KoloniaUmowaDAO();

    @FXML
    private void initialize() {
        idUmowyColumn.setCellValueFactory(new PropertyValueFactory<>("idUmowy"));
        umowaNazwaColumn.setCellValueFactory(new PropertyValueFactory<>("umowaNazwa"));
        idKoloniiColumn.setCellValueFactory(new PropertyValueFactory<>("idKolonii"));
        iloscMiejscColumn.setCellValueFactory(new PropertyValueFactory<>("iloscMiejsc"));
        dataRozpoczeciaColumn.setCellValueFactory(new PropertyValueFactory<>("dataRozpoczecia"));
        dataZakonczeniaColumn.setCellValueFactory(new PropertyValueFactory<>("dataZakonczenia"));
        cenaColumn.setCellValueFactory(new PropertyValueFactory<>("cena"));

        ObservableList<KoloniaUmowa> reportList = FXCollections.observableArrayList(reportDAO.getKoloniaUmowaReport());
        reportTable.setItems(reportList);
    }
}
