package controller;

import dao.PosrednikDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Posrednik;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PosrednikController {
    @FXML
    private TableView<Posrednik> posrednikTable;
    @FXML
    private TableColumn<Posrednik, Integer> idPosrednikaColumn;
    @FXML
    private TableColumn<Posrednik, String> nazwaColumn;
    @FXML
    private TableColumn<Posrednik, String> emailColumn;
    @FXML
    private TableColumn<Posrednik, String> nrTelefonuColumn;
    @FXML
    private TableColumn<Posrednik, Integer> nipColumn;
    @FXML
    private TableColumn<Posrednik, Integer> idAdresColumn;

    private PosrednikDAO posrednikDAO = new PosrednikDAO();

    @FXML
    private void initialize() {
        idPosrednikaColumn.setCellValueFactory(new PropertyValueFactory<>("idPosrednika"));
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        nrTelefonuColumn.setCellValueFactory(new PropertyValueFactory<>("nrTelefonu"));
        nipColumn.setCellValueFactory(new PropertyValueFactory<>("nip"));
        idAdresColumn.setCellValueFactory(new PropertyValueFactory<>("idAdres"));

        ObservableList<Posrednik> posrednikList = FXCollections.observableArrayList(posrednikDAO.getAllPosrednik());
        posrednikTable.setItems(posrednikList);
    }
}
