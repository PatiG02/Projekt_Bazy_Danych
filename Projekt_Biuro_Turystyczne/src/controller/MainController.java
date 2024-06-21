package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import report.KoloniaUmowaReportFile;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private VBox rootVBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (rootVBox != null) {
	        Image backgroundImage = new Image(getClass().getResourceAsStream("/resources/pelican_logo.png"));
	        BackgroundImage background = new BackgroundImage(backgroundImage,
	                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
	                BackgroundPosition.CENTER,
	                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
	        rootVBox.setBackground(new Background(background));
        } else {
            System.err.println("rootVBox is null");
        }
    }


    @FXML
    private void handleOpenKolonia() {
        openWindow("/view/KoloniaView.fxml", "Kolonia");
    }

    @FXML
    private void handleOpenAdres() {
        openWindow("/view/AdresView.fxml", "Adres");
    }
    
    @FXML
    private void handleOpenUmowa() { 
        openWindow("/view/UmowaView.fxml", "Umowa");
    }

    @FXML
    private void handleShowKoloniaUmowaReport() { 
        openWindow("/view/KoloniaUmowaReportView.fxml", "Kolonia Umowa Report");
    }
    
    @FXML
    private void handleGenerateKoloniaUmowaReport() {
        try {
            KoloniaUmowaReportFile.saveKoloniaUmowaReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void openWindow(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/pelican_logo.png")));
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
