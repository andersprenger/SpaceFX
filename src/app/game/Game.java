package app.game;

import app.game.entities.enemies.AngryInvaderB;
import app.game.entities.player.Cannon;
import app.game.objects.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.LinkedList;

/**
 * Handles the game lifecycle and behavior
 *
 * @author Anderson Sprenger
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public class Game {
    private static Game game = null;
    private Cannon cannon;
    private List<GameObject> activeGameObjects;
    private boolean gameOver;
    private int score;
    private int lives;

    private Game() {
        gameOver = false;
        score = 0;
        lives = 3;
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

    public int getLives() {
        return lives;
    }

    public void decreaseLives() {
        lives--;

        if (lives == 0) {
            setGameOver();
        }
    }

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public void addChar(GameObject c) {
        activeGameObjects.add(c);
        c.start();
    }

    public void eliminate(GameObject c) {
        activeGameObjects.remove(c);
    }

    public void start() {
        // Repositório de personagens
        activeGameObjects = new LinkedList<>();

        // Adiciona o canhão
        cannon = new Cannon(400, 550);
        activeGameObjects.add(cannon);

        // Adiciona Invaders
        for (int i = 0; i < 8; i++) {
            activeGameObjects.add(new AngryInvaderB(100 + (i * 60), 60 + i * 40));
        }

        for (GameObject c : activeGameObjects) {
            c.start();
        }
    }

    public void update(long currentTime, long deltaTime) {
        if (gameOver) {
            return;
        }

        if (activeGameObjects.stream().noneMatch((e) -> (e.isEnemy()))) {
            // System.out.println("w/o enemies"); load another level
        }

        for (int i = 0; i < activeGameObjects.size(); i++) {
            GameObject este = activeGameObjects.get(i);
            este.update(deltaTime);
            for (int j = 0; j < activeGameObjects.size(); j++) {
                GameObject outro = activeGameObjects.get(j);
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
        for (GameObject c : activeGameObjects) {
            c.draw(graphicsContext);
        }
    }
}
