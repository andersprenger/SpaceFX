package game.framework;

import game.Ball;
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
    private List<Character> activeChars;
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
        return (game);
    }

    public void addChar(Character c) {
        activeChars.add(c);
        c.start();
    }

    public void eliminate(Character c) {
        activeChars.remove(c);
    }

    public void start() {
        // Repositório de personagens
        activeChars = new LinkedList<>();

        // Adiciona o canhão
        cannon = new Cannon(400, 550);
        activeChars.add(cannon);

        // Adiciona bolas
        for (int i = 0; i < 5; i++) {
            activeChars.add(new Ball(100 + (i * 60), 60 + i * 40));
        }

        // Adiciona pinguim (bugado)
//        activeChars.add(new Pinguim(100, 270));
//        activeChars.add(new Pinguim(10,300));

        for (Character c : activeChars) {
            c.start();
        }
    }

    public void update(long currentTime, long deltaTime) {
        if (gameOver) {
            return;
        }

        for (int i = 0; i < activeChars.size(); i++) {
            Character este = activeChars.get(i);
            este.update(deltaTime);
            for (int j = 0; j < activeChars.size(); j++) {
                Character outro = activeChars.get(j);
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
        for (Character c : activeChars) {
            c.draw(graphicsContext);
        }
    }
}
