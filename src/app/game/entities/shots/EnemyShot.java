package app.game.entities.shots;

import app.game.abstracts.Enemy;
import app.game.abstracts.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 * Represents an enemy shot that crosses the screen from the enemy height to bottom and then dismiss
 *
 * @author Anderson Sprenger (19111109-5)
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */

public class EnemyShot extends Shot {
    public EnemyShot(int px, int py) {
        super(px, py);
    }

    @Override
    public void testCollision(GameObject anotherGameObject) {
        if (anotherGameObject instanceof EnemyShot || anotherGameObject instanceof Enemy ) {
            return;
        }
        // método para colidir o tiro inimigo com o tiro normal (superclasse)
        superTestCollision(anotherGameObject);
    }

    @Override
    public void update(long deltaTime) {
        if (didCollide()) {
            deactivate();
        } else {
            setPosY(getY() + 3);
            // Se chegou na parte superior da tela ...
            if (getY() <= getLMinV()) {
                // Desaparece
                deactivate();
            }
        }
    }

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Paint.valueOf("#FF0000"));
        graphicsContext.fillRect(getX(), getY(), 8, 16);
    }
}
