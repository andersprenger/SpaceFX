package game.object;

import javafx.scene.canvas.GraphicsContext;

/**
 * Represents the basic game character
 *
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public interface GameObject {
    boolean isEnemy();

    int getX();

    int getY();

    int getHeight();

    int getWidth();

    void testCollision(GameObject c);

    boolean didCollide();

    void setCollide();

    void start();

    boolean isActive();

    void update(long deltaTime);

    void draw(GraphicsContext graphicsContext);
}
