package com.example.morpion_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class ChoixNomJoueurController {

    @FXML
    private TextField nomJoueur1;

    @FXML
    private TextField nomJoueur2;

    @FXML
    private RadioButton ordreJoueur1First;

    @FXML
    private RadioButton ordreJoueur2First;

    @FXML
    private ToggleGroup ordreTour;

    private Joueur joueur1;
    private Joueur joueur2;

    public void setJoueurs(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    @FXML
    void onRetourButtonClick(ActionEvent event) throws IOException {

        // Charger le fichier FXML pour la page de jeu
        FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
        Parent root = loader.load();

        // Créer une nouvelle scène avec la page d'accueil
        Scene sceneAccueil = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tic-Tac-Toe - Accueil");
        stage.setScene(sceneAccueil);
    }

    @FXML
    void onJouerButton(ActionEvent event) throws IOException {

        if ((!nomJoueur1.getText().isEmpty()) && (!nomJoueur2.getText().isEmpty()) && (!nomJoueur1.getText().equals(nomJoueur2.getText()))){

            // Charger le fichier FXML pour la page de jeu
            FXMLLoader loaderGame = new FXMLLoader(getClass().getResource("game.fxml"));
            Parent root;
            root = loaderGame.load();

            // Créer une nouvelle scène avec la page de jeu
            Scene sceneGame = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Tic-Tac-Toe - Jeu");
            stage.setScene(sceneGame);

            joueur1.setNom(nomJoueur1.getText());
            joueur2.setNom(nomJoueur2.getText());

            GameController controllerGame = loaderGame.getController();
            controllerGame.setJoueurs(joueur1, joueur2);

            if (ordreJoueur1First.isSelected()) {
                joueur1.setTour(true);
                joueur2.setTour(false);
            }

            else if (ordreJoueur2First.isSelected()) {
                joueur2.setTour(true);
                joueur1.setTour(false);
            }
            // sinon, c'est aléatoire
            else {
                Random random = new Random();
                int randomInt = random.nextInt(2); // Génère un nombre aléatoire entre 0 et 1

                if (randomInt == 0) {
                    joueur1.setTour(true);
                    joueur2.setTour(false);
                } else {
                    joueur2.setTour(true);
                    joueur1.setTour(false);
                }
            }

            controllerGame.reset();
        }
    }
}