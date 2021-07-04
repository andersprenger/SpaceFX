package app.scores;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * ScoresViewController.java <p/>
 * Controls the high scores screen represented by the menu.fxml file.
 *
 * @author Anderson Sprenger (19111109-5)
 */
public class ScoresViewController {

    @FXML Label p1score;
    @FXML Label p2score;
    @FXML Label p3score;
    @FXML Label p4score;
    @FXML Label p5score;
    @FXML Label p6score;
    @FXML Label p7score;
    @FXML Label p8score;
    @FXML Label p9score;
    @FXML Label p10score;

    @FXML Label p1name;
    @FXML Label p2name;
    @FXML Label p3name;
    @FXML Label p4name;
    @FXML Label p5name;
    @FXML Label p6name;
    @FXML Label p7name;
    @FXML Label p8name;
    @FXML Label p9name;
    @FXML Label p10name;

    @FXML Button scoresBackToMenuButton;

    public void buttonPressed(ActionEvent e) throws IOException {
        Main.screen.setScene(Main.startMenu());
    }

    // TODO: set names & score after the feature be done...
}
