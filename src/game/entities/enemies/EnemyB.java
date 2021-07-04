package game.entities.enemies;

import game.object.GameObject;
import game.Game;
import game.tool.Params;
import game.entities.objects.EnemyShot;
import game.object.Enemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Represents a simple enemy that crosses the screen over and over again and shots
 *
 * @author Anderson Sprenger (19111109-5)
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public class EnemyB extends Enemy {
    Integer baseSpeed = null;

    public EnemyB(int px, int py) {
        super(px, py);

        setImage("resources/enemies/3.png");
    }

    public EnemyB(int px, int py, int speed) {
        super(px, py);

        setImage("resources/enemies/3.png");
        setSpeed(speed);
        baseSpeed = speed;
    }

    @Override
    public void start() {
        setDirH(-1);
        setSpeed(4);
    }

    @Override
    public void update(long deltaTime) {
        if (didCollide()) {
            Game.getInstance().addScore();
            Game.getInstance().addScore();
            Game.getInstance().addScore();

            deactivate();
        } else {
            setPosX(getX() + getDirH() * getSpeed());
            if (Params.getInstance().nextInt(200) == 0) {
                Game.getInstance().addChar(new EnemyShot(getX()+24, getY() + 64));
            }
            // Se chegou no lado esquerdo da tela ...
            if (getX() <= getLMinH()) {
                // Reposiciona no lado direito e ...
                setPosX(getLMaxH());

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
        if (anotherGameObject instanceof EnemyB || anotherGameObject instanceof EnemyShot) {
            return;
        }

        super.testCollision(anotherGameObject);
    }

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(image, getX(), getY());
    }
}
