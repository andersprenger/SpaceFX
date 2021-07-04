package app.gameover;

import app.Main;
import app.game.Game;
import app.game.util.InputControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * GameoverViewController.java <p/>
 * Controls the game over screen represented by the gameover.fxml file.
 *
 * @author Anderson Sprenger (19111109-5)
 */
public abstract class GameoverViewController implements Initializable, InputControl {
    @FXML Button goToMenuButton;
    @FXML Button tryAgainButton;

    @FXML Label scoreLabel;
    @FXML Label levelLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scoreLabel.setText("Score: " + Game.getInstance().getScore());
        levelLabel.setText("Level" + Game.getInstance().getLevel());
    }

    public void buttonPressed(ActionEvent e) throws IOException {
        if (e.getSource().equals(goToMenuButton)) {
            Main.screen.setScene(Main.startMenu());
        } else if (e.getSource().equals(tryAgainButton)) {
            Main.screen.setScene(Main.startGame());
        }
    }
}
