package app.menu;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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

    @FXML public void buttonAction(ActionEvent e) {
        if (e.getSource().equals(play)) {
            Main.startGame();
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent e) {
        Main.screen.setScene(Main.startGame());
    }
}