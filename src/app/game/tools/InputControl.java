package app.game.tools;

import javafx.scene.input.KeyCode;

/**
 * Implemented if an entity interacts with user input
 *
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public interface InputControl {
    void onInput(KeyCode keyCode, boolean isPressed);
}
