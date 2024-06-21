package controller;

import dao.UmowaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Umowa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UmowaController {
    @FXML
    private TableView<Umowa> umowaTable;
    @FXML
    private TableColumn<Umowa, Integer> idUmowyColumn;
    @FXML
    private TableColumn<Umowa, String> nazwaColumn;
    @FXML
    private TableColumn<Umowa, Integer> idPosrednikaColumn;
    @FXML
    private TableColumn<Umowa, Integer> idKoloniiColumn;
    @FXML
    private TableColumn<Umowa, Integer> idOsobaColumn;
    @FXML
    private TableColumn<Umowa, Integer> idTransportuColumn;
    @FXML
    private TableColumn<Umowa, Integer> idWyzywieniaColumn;

    private UmowaDAO umowaDAO = new UmowaDAO();

    @FXML
    private void initialize() {
        idUmowyColumn.setCellValueFactory(new PropertyValueFactory<>("idUmowy"));
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        idPosrednikaColumn.setCellValueFactory(new PropertyValueFactory<>("idPosrednika"));
        idKoloniiColumn.setCellValueFactory(new PropertyValueFactory<>("idKolonii"));
        idOsobaColumn.setCellValueFactory(new PropertyValueFactory<>("idOsoba"));
        idTransportuColumn.setCellValueFactory(new PropertyValueFactory<>("idTransportu"));
        idWyzywieniaColumn.setCellValueFactory(new PropertyValueFactory<>("idWyzywienia"));

        ObservableList<Umowa> umowaList = FXCollections.observableArrayList(umowaDAO.getAllUmowy());
        umowaTable.setItems(umowaList);
    }
}
