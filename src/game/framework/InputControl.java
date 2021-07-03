package game.framework;

import javafx.scene.input.KeyCode;

/**
 * Represents the basic game character
 *
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public interface InputControl {
    void onInput(KeyCode keyCode, boolean isPressed);
}
