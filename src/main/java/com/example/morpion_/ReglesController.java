package com.example.morpion_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ReglesController {

    @FXML
    void onFermerButtonClick(ActionEvent event) {
        Button source = (Button)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
}