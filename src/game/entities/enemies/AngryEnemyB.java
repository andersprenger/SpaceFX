package game.entities.enemies;

import game.object.GameObject;
import javafx.scene.canvas.GraphicsContext;

/**
 * Represents a simple enemy that crosses the screen over and over again, has lives and shots
 *
 * @author Anderson Sprenger (19111109-5)
 */

public class AngryEnemyB extends EnemyB {
    boolean wasShot = false;

    public AngryEnemyB(int px, int py) {
        super(px, py);
    }

    public AngryEnemyB(int px, int py, int speed) {
        super(px, py, speed);
    }

    @Override
    public void testCollision(GameObject anotherGameObject) {
        if (!wasShot) {
            wasShot = true;
            return;
        }

        super.testCollision(anotherGameObject);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

        super.draw(graphicsContext);
    }
}
