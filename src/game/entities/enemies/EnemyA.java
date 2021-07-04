package game.entities.enemies;

import game.object.GameObject;
import game.Game;
import game.tool.Params;
import game.object.Enemy;
import javafx.scene.canvas.GraphicsContext;

/**
 * Represents a simple enemy that crosses the screen over and over again
 *
 * @author Anderson Sprenger (19111109-5)
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public class EnemyA extends Enemy {
    Integer baseSpeed = null;

    public EnemyA(int px, int py) {
        super(px, py);

        setImage("resources/enemies/1.png");
    }

    public EnemyA(int px, int py, int speed) {
        super(px, py);

        setImage("resources/enemies/1.png");
        setSpeed(speed);
        baseSpeed = speed;
    }

    @Override
    public void start() {
        setDirH(1);
    }

    @Override
    public void update(long deltaTime) {
        if (didCollide()) {
            Game.getInstance().addScore();
            deactivate();
        } else {
            setPosX(getX() + getDirH() * getSpeed());
            // Se chegou no lado direito da tela ...
            if (getX() >= getLMaxH()) {
                // Reposiciona no lado esquerdo e ...
                setPosX(getLMinH());

                // Sorteia o passo de avanço [1,5]
                if (baseSpeed == null) {
                    setSpeed(Params.getInstance().nextInt(5) + 1);
                } else {
                    setSpeed(Params.getInstance().nextInt(5) + baseSpeed);
                }
            }
        }
    }

    @Override
    public void testCollision(GameObject anotherGameObject) {
        if (anotherGameObject instanceof EnemyA) {
            return;
        }

        super.testCollision(anotherGameObject);
    }

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(image, getX(), getY());
    }
}
