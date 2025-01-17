package com.example.morpion_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ScoreController {

    @FXML
    private Label nbVictoireJ1;

    @FXML
    private Label nbVictoireJ2;

    @FXML
    private Label nomJoueur1Score;

    @FXML
    private Label nomJoueur2Score;

    private Joueur joueur1;
    private Joueur joueur2;

    public void majJoueurs(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        setNomJoueur1Score(joueur1.getNom());
        setNomJoueur2Score(joueur2.getNom());
        setNbVictoireJ1(joueur1.getNbVictoire());
        setNbVictoireJ2(joueur2.getNbVictoire());
    }

    public void setNbVictoireJ1(int nbVictoireJ1) {
        this.nbVictoireJ1.setText(""+nbVictoireJ1);
        changeCouleurScore();
    }

    public void setNbVictoireJ2(int nbVictoireJ2) {
        this.nbVictoireJ2.setText(""+nbVictoireJ2);
        changeCouleurScore();
    }

    public void changeCouleurScore() {
        if (Integer.parseInt(this.nbVictoireJ1.getText()) > Integer.parseInt(this.nbVictoireJ2.getText())) {
            this.nbVictoireJ1.setTextFill(Color.valueOf("#FFD700"));
            this.nbVictoireJ2.setTextFill(Color.WHITE);
        }
        else if (Integer.parseInt(this.nbVictoireJ2.getText()) > Integer.parseInt(this.nbVictoireJ1.getText())) {
            this.nbVictoireJ2.setTextFill(Color.valueOf("#FFD700"));
            this.nbVictoireJ1.setTextFill(Color.WHITE);
        }
        else {
            this.nbVictoireJ2.setTextFill(Color.WHITE);
            this.nbVictoireJ1.setTextFill(Color.WHITE);
        }
    }

    public void setNomJoueur1Score(String nomJoueur1Score) {
        this.nomJoueur1Score.setText(nomJoueur1Score);
    }

    public void setNomJoueur2Score(String nomJoueur2Score) {
        this.nomJoueur2Score.setText(nomJoueur2Score);
    }

    @FXML
    void onRejouerMnomsClick(ActionEvent event) {
        try {
            // fermeture de la fenêtre modale
            Button source = (Button)event.getSource();
            Stage stageScore = (Stage)source.getScene().getWindow();
            stageScore.close();

            // Charger le fichier FXML pour la page de jeu
            FXMLLoader loaderGame = new FXMLLoader(getClass().getResource("game.fxml"));
            Parent root;
            root = loaderGame.load();
            Scene sceneGame = new Scene(root);

            // récupération de la fenêtre parente pour en changer le titre et la scene
            Stage stageParente = (Stage) stageScore.getOwner();

            stageParente.setTitle("Tic-Tac-Toe - Jeu");
            stageParente.setScene(sceneGame);

            // récupération du GameController pour accéder à ses méthodes
            GameController controllerGame = loaderGame.getController();

            // Passer les instances des joueurs à GameController
            controllerGame.setJoueurs(joueur1, joueur2);

            controllerGame.reset();
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    @FXML
    void onRejouerNnomsClick(ActionEvent event) {
        try {
            // fermeture de la fenêtre modale
            Button source = (Button) event.getSource();
            Stage stageScore = (Stage) source.getScene().getWindow();
            stageScore.close();

            // Création d'une nouvelle scène prenant le fxml de la page de choix du nom des joueurs (choixNomJoueur.fxml)
            FXMLLoader loaderCNJ = new FXMLLoader(getClass().getResource("choixNomJoueur.fxml"));
            Parent root;
            root = loaderCNJ.load();
            Scene sceneChoixNomJoueur = new Scene(root);

            // récupération de la fenêtre parente pour en changer le titre et la scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Stage stageParente = (Stage) stage.getOwner();

            stageParente.setTitle("Tic-Tac-Toe - Choix du nom des joueurs");
            stageParente.setScene(sceneChoixNomJoueur);

            // récupération du ChoixNomJoueurController pour accéder à ses méthodes
            ChoixNomJoueurController controllerCNJ = loaderCNJ.getController();

            // Passer les instances des joueurs à ChoixNomJoueurController pour que les scores soient concerver lors du changement des noms (que ce soient les mêmes instances de Joueurs)
            controllerCNJ.setJoueurs(joueur1, joueur2);
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    @FXML
    void onQuitterClick(ActionEvent event) {
        try {
            // fermeture de la fenêtre modale
            Button source = (Button) event.getSource();
            Stage stageScore = (Stage) source.getScene().getWindow();
            stageScore.close();

            // Création d'une nouvelle scène prenant le fxml de la page de choix du nom des joueurs (choixNomJoueur.fxml)
            Parent root = FXMLLoader.load(getClass().getResource("accueil.fxml"));
            Scene sceneAccueil = new Scene(root);

            // récupération de la fenêtre parente pour en changer le titre et la scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Stage stageParente = (Stage) stage.getOwner();

            stageParente.setTitle("Tic-Tac-Toe - Accueil");
            stageParente.setScene(sceneAccueil);
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}