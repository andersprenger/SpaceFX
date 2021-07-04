package app.menu;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * MenuController.java <p/>
 * Controls the menu screen represented by the menu.fxml file.
 *
 * @author Anderson Sprenger
 */

public class MenuViewController {

    @FXML Button play;
    @FXML Button config;
    @FXML Button scores;

    @FXML public void buttonPressed(ActionEvent e) throws IOException {
        if (e.getSource().equals(play)) {
            Main.screen.setScene(Main.startGame());
        } else if (e.getSource().equals(config)) {
            Main.screen.setScene(Main.startSettings());
        } else if (e.getSource().equals(scores)) {
            Main.screen.setScene(Main.startScore());
        }
    }
}