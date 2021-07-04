package game.entities.enemies;

import game.objects.GameObject;

/**
 * Represents a simple enemy that crosses the screen over and over again, has lives and shots
 *
 * @author Anderson Sprenger (19111109-5)
 */

public class AngryInvaderB extends InvaderB {

    public AngryInvaderB(int px, int py) {
        super(px, py);
    }

    public AngryInvaderB(int px, int py, int speed) {
        super(px, py, speed);
    }
}
