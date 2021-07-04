package game.entities.enemies;

import game.Character;
import game.Entity;
import game.Game;
import game.Params;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Represents a simple enemy that crosses the screen over and over again
 *
 * @author Anderson Sprenger (19111109-5)
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public class EnemyA extends Entity {
    private Image image;
    Integer baseSpeed = null;

    public EnemyA(int px, int py) {
        super(px, py);

        try {
            // Carrega a imagem ajustando a altura para 40 pixels
            // mantendo a proporção em ambas dimensões
            image = new Image("resources/enemies/1.png", 0, 40, true, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public EnemyA(int px, int py, int speed) {
        super(px, py);

        try {
            // Carrega a imagem ajustando a altura para 40 pixels
            // mantendo a proporção em ambas dimensões
            image = new Image("resources/enemies/2.png", 0, 40, true, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        setSpeed(speed);
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
    public boolean isEnemy() {
        return true;
    }

    @Override
    public void testCollision(Character anotherCharacter) {
        if (anotherCharacter instanceof EnemyA) {
            return;
        }

        super.testCollision(anotherCharacter);
    }

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(image, getX(), getY());
    }
}
