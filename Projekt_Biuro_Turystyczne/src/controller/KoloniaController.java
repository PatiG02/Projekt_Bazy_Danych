package controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import dao.KoloniaDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Kolonia;

public class KoloniaController {
    @FXML
    private TableView<Kolonia> koloniaTable;
    @FXML
    private TableColumn<Kolonia, Integer> idKoloniiColumn;
    @FXML
    private TableColumn<Kolonia, Integer> iloscMiejscColumn;
    @FXML
    private TableColumn<Kolonia, LocalDate> dataRozpoczeciaColumn;
    @FXML
    private TableColumn<Kolonia, LocalDate> dataZakonczeniaColumn;
    @FXML
    private TableColumn<Kolonia, BigDecimal> cenaColumn;
    @FXML
    private TableColumn<Kolonia, Integer> idMiejscowosciColumn;
    @FXML
    private TableColumn<Kolonia, Integer> idZakwaterowaniaColumn;
    @FXML
    private TableColumn<Kolonia, Integer> idAdresColumn;

    private KoloniaDAO koloniaDAO = new KoloniaDAO();

    @FXML
    private void initialize() {
        idKoloniiColumn.setCellValueFactory(new PropertyValueFactory<>("idKolonii"));
        iloscMiejscColumn.setCellValueFactory(new PropertyValueFactory<>("iloscMiejsc"));
        dataRozpoczeciaColumn.setCellValueFactory(new PropertyValueFactory<>("dataRozpoczecia"));
        dataZakonczeniaColumn.setCellValueFactory(new PropertyValueFactory<>("dataZakonczenia"));
        cenaColumn.setCellValueFactory(new PropertyValueFactory<>("cena"));
        idMiejscowosciColumn.setCellValueFactory(new PropertyValueFactory<>("idMiejscowosci"));
        idZakwaterowaniaColumn.setCellValueFactory(new PropertyValueFactory<>("idZakwaterowania"));
        idAdresColumn.setCellValueFactory(new PropertyValueFactory<>("idAdres"));

        koloniaTable.setItems(FXCollections.observableArrayList(koloniaDAO.getAllKolonia()));
    }
}
