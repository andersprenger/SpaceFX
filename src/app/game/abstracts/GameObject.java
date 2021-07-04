package app.game.abstracts;

import javafx.scene.canvas.GraphicsContext;

/**
 * Represents the basic game object
 *
 * @author Anderson Sprenger (19111109-5)
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public interface GameObject {
    boolean isEnemy();

    int getId();

    void addCollider(GameObject o);

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
