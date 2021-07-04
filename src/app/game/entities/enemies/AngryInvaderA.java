package app.game.entities.enemies;

import app.game.abstracts.GameObject;

/**
 * Represents a simple enemy that crosses the screen over and over again and has lives
 *
 * @author Anderson Sprenger (19111109-5)
 */
public class AngryInvaderA extends InvaderA {
    private boolean wasShot;

    public AngryInvaderA(int px, int py) {
        super(px, py);

        wasShot = false;
    }

    public AngryInvaderA(int px, int py, int speed) {
        super(px, py, speed);

        wasShot = false;
    }

    @Override
    public void addCollider(GameObject o) {
        if (!wasShot) {
            super.addCollider(o, false);

            wasShot = true;
            setImage("resources/enemies/2.png");
        }

        super.addCollider(o);
    }
}
