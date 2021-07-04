package game.entities.enemies;

import game.object.GameObject;
import javafx.scene.canvas.GraphicsContext;

/**
 * Represents a simple enemy that crosses the screen over and over again and has lives
 *
 * @author Anderson Sprenger (19111109-5)
 */
public class AngryEnemyA extends EnemyA{
    boolean wasShot = false;

    public AngryEnemyA(int px, int py) {
        super(px, py);
    }

    public AngryEnemyA(int px, int py, int speed) {
        super(px, py, speed);
    }

    @Override
    public void testCollision(GameObject anotherGameObject) {
        if (!wasShot) {
            wasShot = true;
            setImage("resources/enemies/2.png");

            return;
        }

        super.testCollision(anotherGameObject);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
    }
}
