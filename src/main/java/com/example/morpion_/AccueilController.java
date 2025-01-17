package com.example.morpion_;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AccueilController {

    private Joueur joueur1 = new Joueur();
    private Joueur joueur2 = new Joueur();

    @FXML
    void onJouer1v1ButtonClick(ActionEvent event) throws IOException {

        // Charger le fichier FXML pour la page de jeu
        FXMLLoader loaderCNJ = new FXMLLoader(getClass().getResource("choixNomJoueur.fxml"));
        Parent root = loaderCNJ.load();

        // Créer une nouvelle scène avec la page de choix du nom des joueurs
        Scene sceneChoixNomJoueur = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tic-Tac-Toe - Choix du nom des joueurs");
        stage.setScene(sceneChoixNomJoueur);

        // récupération du ChoixNomJoueurController pour accéder à ses méthodes
        ChoixNomJoueurController controllerCNJ = loaderCNJ.getController();

        // Passer les instances des joueurs à ChoixNomJoueurController
        controllerCNJ.setJoueurs(joueur1, joueur2);
    }

}