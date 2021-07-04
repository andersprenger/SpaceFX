package game.entities.shots;

import game.objects.GameObject;
import game.objects.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 * Represents a shot that crosses the screen from bottom to up and then dismiss
 *
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public class Shot extends Entity {
    public Shot(int px, int py) {
        super(px, py);
    }

    @Override
    public void start() {
        setDirV(-1);
        setSpeed(3);
    }

    @Override
    public void testCollision(GameObject anotherGameObject) {
        // Não verifica colisão de um tiro com outro tiro
        if (anotherGameObject instanceof Shot) {
            return;
        }

        super.testCollision(anotherGameObject);
    }

    public void superTestCollision(GameObject anotherGameObject) {
        super.testCollision(anotherGameObject);
    }

    @Override
    public void update(long deltaTime) {
        if (didCollide()) {
            deactivate();
        } else {
            setPosY(getY() + getDirV() * getSpeed());
            // Se chegou na parte superior da tela ...
            if (getY() <= getLMinV()) {
                // Desaparece
                deactivate();
            }
        }
    }

    @Override
    public int getHeight() {
        return 16;
    }

    @Override
    public int getWidth() {
        return 8;
    }

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Paint.valueOf("#00FF00"));
        graphicsContext.fillRect(getX(), getY(), 8, 16);
    }
}
