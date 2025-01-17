package com.example.morpion_;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class GameController {

    @FXML
    private Button case00Button;

    @FXML
    private Button case01Button;

    @FXML
    private Button case02Button;

    @FXML
    private Button case10Button;

    @FXML
    private Button case11Button;

    @FXML
    private Button case12Button;

    @FXML
    private Button case20Button;

    @FXML
    private Button case21Button;

    @FXML
    private Button case22Button;

    @FXML
    private Label case00;

    @FXML
    private Label case01;

    @FXML
    private Label case02;

    @FXML
    private Label case10;

    @FXML
    private Label case11;

    @FXML
    private Label case12;

    @FXML
    private Label case20;

    @FXML
    private Label case21;

    @FXML
    private Label case22;

    @FXML
    private GridPane tableDeJeu;

    @FXML
    private Label tourTexte;

    private Joueur joueur1;
    private Joueur joueur2;

    public void setJoueurs(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    @FXML
    void onCase00Clicked(ActionEvent event) {
        changeTextClique(case00);
    }

    @FXML
    void onCase01Clicked(ActionEvent event) {
        changeTextClique(case01);
    }

    @FXML
    void onCase02Clicked(ActionEvent event) {
        changeTextClique(case02);
    }

    @FXML
    void onCase10Clicked(ActionEvent event) {
        changeTextClique(case10);
    }

    @FXML
    void onCase11Clicked(ActionEvent event) {
        changeTextClique(case11);
    }

    @FXML
    void onCase12Clicked(ActionEvent event) {
        changeTextClique(case12);
    }

    @FXML
    void onCase20Clicked(ActionEvent event) {
        changeTextClique(case20);
    }

    @FXML
    void onCase21Clicked(ActionEvent event) {
        changeTextClique(case21);
    }

    @FXML
    void onCase22Clicked(ActionEvent event) {
        changeTextClique(case22);
    }

    @FXML
    private Button reinitialiserButton;

    @FXML
    void onReinitialiserClick(ActionEvent event) {
        reset();
    }

    @FXML
    void onQuitterClick(ActionEvent event) {
        try {
            // Création d'une nouvelle scène prenant le fxml de l'accueil (accueil.fxml)
            Parent root = FXMLLoader.load(getClass().getResource("accueil.fxml"));
            Scene sceneAccueil = new Scene(root);

            // récupération de la fenêtre principale pour en changer le titre et la scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Tic-Tac-Toe - Accueil");
            stage.setScene(sceneAccueil);
        } catch (IOException e) {
            tourTexte.setText("Erreur : " + e.getMessage());
        }
    }

    @FXML
    void onReglesClick(ActionEvent event) {
        // récupération de la fenêtre principale
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // création de la fenêtre non-modale pour les règles
        Stage modalDialog = new Stage();
        modalDialog.initModality(Modality.NONE);
        modalDialog.initOwner(stage);

        // on associe à cette nouvelle fenêtre le fxml correspondant aux règles du jeu
        try {
            Parent root = FXMLLoader.load(getClass().getResource("regles.fxml"));
            Scene scene = new Scene(root);
            modalDialog.setScene(scene);

            // affichage de la fenêtre modale
            modalDialog.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reset() {
        case00.setText("");
        case10.setText("");
        case20.setText("");
        case01.setText("");
        case11.setText("");
        case21.setText("");
        case02.setText("");
        case12.setText("");
        case22.setText("");

        case00Button.setDisable(false);
        case10Button.setDisable(false);
        case20Button.setDisable(false);
        case01Button.setDisable(false);
        case22Button.setDisable(false);
        case11Button.setDisable(false);
        case21Button.setDisable(false);
        case02Button.setDisable(false);
        case12Button.setDisable(false);

        for (Node node : tableDeJeu.getChildren()) {
            node.setStyle("-fx-background-color: #69d7ff;"); // réinitialisation des couleurs des cases en bleu clair
        }
        tour();
    }

    public void testVictoire() {
        String text00 = case00.getText();
        String text10 = case10.getText();
        String text20 = case20.getText();
        String text01 = case01.getText();
        String text11 = case11.getText();
        String text21 = case21.getText();
        String text02 = case02.getText();
        String text12 = case12.getText();
        String text22 = case22.getText();

        if (text00.equals(text10) && text10.equals(text20) && !text00.isEmpty()) {
            surbrillance(0,0);
            surbrillance(0,1);
            surbrillance(0,2);
            victoire();
            return;
        }
        if (text01.equals(text11) && text11.equals(text21) && !text01.isEmpty()) {
            surbrillance(1,0);
            surbrillance(1,1);
            surbrillance(1,2);
            victoire();
            return;
        }
        if (text02.equals(text12) && text12.equals(text22) && !text02.isEmpty()) {
            surbrillance(2,0);
            surbrillance(2,1);
            surbrillance(2,2);
            victoire();
            return;
        }
        if (text00.equals(text01) && text01.equals(text02) && !text00.isEmpty()) {
            surbrillance(0,0);
            surbrillance(1,0);
            surbrillance(2,0);
            victoire();
            return;
        }
        if (text10.equals(text11) && text11.equals(text12) && !text10.isEmpty()) {
            surbrillance(0,1);
            surbrillance(1,1);
            surbrillance(2,1);
            victoire();
            return;
        }
        if (text20.equals(text21) && text21.equals(text22) && !text20.isEmpty()) {
            surbrillance(0,2);
            surbrillance(1,2);
            surbrillance(2,2);
            victoire();
            return;
        }
        if (text00.equals(text11) && text11.equals(text22) && !text00.isEmpty()) {
            surbrillance(0,0);
            surbrillance(1,1);
            surbrillance(2,2);
            victoire();
            return;
        }
        if (text20.equals(text11) && text11.equals(text02) && !text20.isEmpty()) {
            surbrillance(0,2);
            surbrillance(1,1);
            surbrillance(2,0);
            victoire();
        }
        else if (!text00.equals("") && !text10.equals("") && !text20.equals("") && !text01.equals("") && !text11.equals("") && !text21.equals("") && !text02.equals("") && !text12.equals("") && !text22.equals("")) {
            tourTexte.setText("Égalité !");
            PauseTransition pause = new PauseTransition(Duration.millis(500));
            pause.setOnFinished(event -> {
                score();
            });
            pause.play();
        }
    }

    public void surbrillance(int ligne, int colonne) {
        Node node = tableDeJeu.getChildren().get(ligne * 3 + colonne); // on obtient le nœud graphique de la case
        node.setStyle("-fx-background-color: #16c416;"); // changement de la couleur de la case en vert
    }


    public void victoire() {
        case00Button.setDisable(true);
        case10Button.setDisable(true);
        case20Button.setDisable(true);
        case01Button.setDisable(true);
        case11Button.setDisable(true);
        case21Button.setDisable(true);
        case02Button.setDisable(true);
        case12Button.setDisable(true);
        case22Button.setDisable(true);

        if (joueur2.getTour() == true) {
            tourTexte.setText("Victoire de " + joueur1.getNom() + " !");
            joueur1.addVictoire();
        }
        else {
            tourTexte.setText("Victoire de " + joueur2.getNom() + " !");
            joueur2.addVictoire();
        }
        // puase de 500 ms avant d'afficher le score pour permettre au joueur de voir la combinaison gagnante
        PauseTransition pause = new PauseTransition(Duration.millis(500));
        pause.setOnFinished(event -> {
            score();
        });
        pause.play();
    }

    public void score() {
        // récupération de la fenêtre principale
        Stage stage = (Stage) reinitialiserButton.getScene().getWindow();

        // création de la fenêtre modale pour le score
        Stage modalDialog = new Stage(StageStyle.UNDECORATED);
        modalDialog.initModality(Modality.WINDOW_MODAL);
        modalDialog.initOwner(stage);

        // on associe à cette nouvelle fenêtre le fxml correspondant au score
        try {
            FXMLLoader loaderScore = new FXMLLoader(getClass().getResource("score.fxml"));
            Parent root = loaderScore.load();
            Scene scene = new Scene(root);
            modalDialog.setScene(scene);

            ScoreController controllerScore = loaderScore.getController();
            controllerScore.majJoueurs(joueur1, joueur2);

            // affichage de la fenêtre modale
            modalDialog.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void changeTextClique(Label label) {
        if (label.getText().isEmpty()) {
            if (joueur1.getTour() == true) {
                label.setText("X");
            } else {
                label.setText("O");
            }
            joueur1.changeTour();
            joueur2.changeTour();
            tour();
            testVictoire();
        }
    }

    void tour() {
        if (joueur1.getTour() == true) { tourTexte.setText("Au tour de " + joueur1.getNom()); }
        else { tourTexte.setText("Au tour de " + joueur2.getNom()); }
    }
}