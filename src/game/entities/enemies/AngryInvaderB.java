package game.entities.enemies;

import game.objects.GameObject;

/**
 * Represents a simple enemy that crosses the screen over and over again, has lives and shots
 *
 * @author Anderson Sprenger (19111109-5)
 */

public class AngryInvaderB extends InvaderB {
    boolean wasShot;

    public AngryInvaderB(int px, int py) {
        super(px, py);
    }

    public AngryInvaderB(int px, int py, int speed) {
        super(px, py, speed);
    }

    @Override
    public void addCollider(GameObject o) {
        if (!wasShot) {
            super.addCollider(o, false);

            wasShot = true;
            setImage("resources/enemies/4.png");
        }

        super.addCollider(o);
    }
}
