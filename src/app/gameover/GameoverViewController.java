package app.gameover;

import app.Main;
import app.game.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * GameOverViewController.java
 * Controls the game over screen represented by the gameOver.fxml file.
 *
 * @author Anderson Sprenger (19111109-5)
 */
public class GameOverViewController {
    @FXML public Label scoreLabel;
    @FXML public Label levelLabel;

    @FXML public Button goToMenuButton;
    @FXML public Button tryAgainButton;

    public void menuButton(ActionEvent e) throws IOException {
        Main.screen.setScene(Main.startMenu());
    }

    public void tryAgainButton(ActionEvent e) {
        Main.screen.setScene(Main.startGame());
    }

    @FXML public void initialize() {
        scoreLabel.setText("Score: " + Game.getInstance().getScore());
        levelLabel.setText("Level: " + Game.getInstance().getLevel());
    }
}
