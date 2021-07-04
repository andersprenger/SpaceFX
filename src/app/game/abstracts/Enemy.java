package app.game.abstracts;

import app.game.entities.shots.EnemyShot;
import javafx.scene.image.Image;

/**
 * Basic implementation of an Enemy
 *
 * @author Anderson Sprenger (19111109-5)
 */

public abstract class Enemy extends Entity {
    public Image image;

    public void setImage(String imagePath) {
        try {
            // Carrega a imagem ajustando a altura para 40 pixels
            // mantendo a proporção em ambas dimensões
            image = new javafx.scene.image.Image(imagePath, 0, 40, true, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public Enemy(int startX, int startY) {
        super(startX, startY);
    }

    @Override
    public void testCollision(GameObject anotherGameObject) {
        if (anotherGameObject instanceof Enemy || anotherGameObject instanceof EnemyShot) {
            return;
        }

        super.testCollision(anotherGameObject);
    }

    @Override
    public boolean isEnemy() {
        return true;
    }
}
