package app.settings;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * SettingsViewController.java <p/>
 * Controls the settings screen represented by the menu.fxml file.
 *
 * @author Anderson Sprenger (19111109-5)
 */
public class SettingsViewController {
    @FXML Button settingsBackToMenuButton;
    @FXML Button updateName;

    public void buttonPressed(ActionEvent e) throws IOException {
        if (e.getSource().equals(settingsBackToMenuButton)) {
            Main.screen.setScene(Main.startMenu());
        } else if (e.getSource().equals(updateName)) {
            // TODO: update name when score feature be done...
        }
    }
}
