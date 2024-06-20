package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Adres.fxml"))));
            primaryStage.setTitle("Adres Management");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}