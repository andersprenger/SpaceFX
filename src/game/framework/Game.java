package game.framework;

import game.Ball;
import game.Pinguim;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.LinkedList;

/**
 * Handles the game lifecycle and behavior
 *
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public class Game {
    private static Game game = null;
    private Cannon cannon;
    private List<Character> activeCharacters;
    private boolean gameOver;
    private int score;

    private Game() {
        gameOver = false;
        score = 0;
    }

    public void setGameOver() {
        gameOver = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        score++;
    }

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public void addChar(Character c) {
        activeCharacters.add(c);
        c.start();
    }

    public void eliminate(Character c) {
        activeCharacters.remove(c);
    }

    public void start() {
        // Repositório de personagens
        activeCharacters = new LinkedList<>();

        // Adiciona o canhão
        cannon = new Cannon(400, 550);
        activeCharacters.add(cannon);

        // Adiciona bolas
        for (int i = 0; i < 5; i++) {
            activeCharacters.add(new Ball(100 + (i * 60), 60 + i * 40));
        }

        //Adiciona pinguim (bugado)
        activeCharacters.add(new Pinguim(100, 270));
        activeCharacters.add(new Pinguim(10,300));

        for (Character c : activeCharacters) {
            c.start();
        }
    }

    public void update(long currentTime, long deltaTime) {
        if (gameOver) {
            return;
        }

        for (int i = 0; i < activeCharacters.size(); i++) {
            Character este = activeCharacters.get(i);
            este.update(deltaTime);
            for (int j = 0; j < activeCharacters.size(); j++) {
                Character outro = activeCharacters.get(j);
                if (este != outro) {
                    este.testCollision(outro);
                }
            }
        }
    }

    public void onInput(KeyCode keyCode, boolean isPressed) {
        cannon.onInput(keyCode, isPressed);
    }

    public void draw(GraphicsContext graphicsContext) {
        for (Character c : activeCharacters) {
            c.draw(graphicsContext);
        }
    }
}
