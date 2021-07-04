package game.entities.enemies;

/**
 * Represents a simple enemy that crosses the screen over and over again and has lives
 *
 * @author Anderson Sprenger (19111109-5)
 */
public class AngryEnemyA extends EnemyA{
    public AngryEnemyA(int px, int py) {
        super(px, py);
    }

    public AngryEnemyA(int px, int py, int speed) {
        super(px, py, speed);
    }
}
