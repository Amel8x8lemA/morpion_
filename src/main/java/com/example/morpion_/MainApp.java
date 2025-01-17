package com.example.morpion_;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlAccueilLoader = new FXMLLoader(MainApp.class.getResource("accueil.fxml"));
        Scene sceneAccueil = new Scene(fxmlAccueilLoader.load(), 600, 450);
        stage.setTitle("Tic-Tac-Toe - Accueil");
        stage.setScene(sceneAccueil);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}