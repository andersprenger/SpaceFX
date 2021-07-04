package game.entities.enemies;

import game.objects.GameObject;

/**
 * Represents a simple enemy that crosses the screen over and over again and has lives
 *
 * @author Anderson Sprenger (19111109-5)
 */
public class AngryInvaderA extends InvaderA {

    public AngryInvaderA(int px, int py) {
        super(px, py);
    }

    public AngryInvaderA(int px, int py, int speed) {
        super(px, py, speed);
    }
}
