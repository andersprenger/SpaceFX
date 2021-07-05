package app.game;

import app.Main;
import app.game.entities.enemies.AngryInvaderA;
import app.game.entities.enemies.AngryInvaderB;
import app.game.entities.enemies.InvaderA;
import app.game.entities.enemies.InvaderB;
import app.game.entities.player.Cannon;
import app.game.abstracts.GameObject;
import app.game.util.Params;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.util.List;
import java.util.LinkedList;

/**
 * Handles the game lifecycle and behavior
 *
 * @author Anderson Sprenger (19111109-5)
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
    private int level;

    private Game() {
        gameOver = false;
        score = 0;
        lives = 3;
        level = 1;
    }

    public void setGameOver() {
        gameOver = true;
        try {
            Main.screen.setScene(Main.startGameOver());
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void loadLevel() {
        if (level == 1) {
                activeGameObjects.add(new InvaderA(100 + (1 * 60), 60 + 1 * 40));
                activeGameObjects.add(new InvaderA(100 + (2 * 60), 60 + 2 * 40));
                activeGameObjects.add(new InvaderB(100 + (3 * 60), 60 + 3 * 40));
                activeGameObjects.add(new InvaderB(100 + (4 * 60), 60 + 4 * 40));
                activeGameObjects.add(new AngryInvaderA(100 + (5 * 60), 60 + 5 * 40));
                activeGameObjects.add(new AngryInvaderB(100 + (6 * 60), 60 + 6 * 40));
        } else if (level % 2 == 0) {
            for (int i = 0; i < level * 3; i++) {
                activeGameObjects.add(new InvaderB(100 + (i * 60), 60 + i * 40, level * 2));
            }

            if (level >= 4) {
                for (int i = 0; i < level * 2; i++) {
                    activeGameObjects.add(new AngryInvaderB(Params.getInstance().nextInt(4) * 60, 60 + i * 40, level * 2));
                }
            }
        } else {
            for (int i = 0; i < level * 3; i++) {
                activeGameObjects.add(new InvaderA(100 + (i * 60), 60 + i * 40, level * 2));
            }

            if (level >= 4) {
                for (int i = 0; i < level * 2; i++) {
                    activeGameObjects.add(new AngryInvaderA(Params.getInstance().nextInt(4) * 60, 60 + i * 40, level * 2));
                }
            }
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        score += 10;
    }

    public int getLives() {
        return lives;
    }

    public int getLevel() {
        return level;
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
        //seta gameover para false, case try again...
        gameOver = false;

        // level comeca do 1
        level = 1;

        // Repositório de personagens
        activeGameObjects = new LinkedList<>();

        // Adiciona o canhão
        cannon = new Cannon(400, 550);
        activeGameObjects.add(cannon);

        // Adiciona Invaders
        for (int i = 0; i < 8; i++) {
            loadLevel();
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
            level++;
            loadLevel();
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
