package game.objects;

import javafx.scene.canvas.GraphicsContext;

/**
 * Represents the basic game object
 *
 * @author Anderson Sprenger
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public interface GameObject {
    boolean isEnemy();

    int getId();

    int getX();

    int getY();

    int getHeight();

    int getWidth();

    void testCollision(GameObject c);

    boolean didCollide();

    void setCollide(boolean b);

    void start();

    boolean isActive();

    void update(long deltaTime);

    void draw(GraphicsContext graphicsContext);
}
