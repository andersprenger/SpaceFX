package game.framework;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;

/**
 * Represents the game Gun
 *
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public class Cannon extends Entity implements InputControl {
    private int RELOAD_TIME = 100000000; // Time is in nanoseconds
    private int shot_timer = 0;

    public Cannon(int px, int py) {
        super(px, py);
    }

    @Override
    public void start() {
        setLimH(20, Params.WINDOW_WIDTH - 20);
        setLimV(Params.WINDOW_HEIGHT - 100, Params.WINDOW_HEIGHT);
    }

    @Override
    public void update(long deltaTime) {
        if (didCollide()) {
            Game.getInstance().setGameOver();
        }
        setPosX(getX() + getDirH() * getSpeed());
        if (shot_timer > 0) shot_timer -= deltaTime;
    }

    @Override
    public void onInput(KeyCode keyCode, boolean isPressed) {
        if (keyCode == KeyCode.LEFT) {
            int dh = isPressed ? -1 : 0;
            setDirH(dh);
        }
        if (keyCode == KeyCode.RIGHT) {
            int dh = isPressed ? 1 : 0;
            setDirH(dh);
        }
        if (keyCode == KeyCode.SPACE) {
            if (shot_timer <= 0) {
                Game.getInstance().addChar(new Shot(getX() + 16, getY() - 32));
                shot_timer = RELOAD_TIME;
            }
        }
        //if (keyCode == KeyCode.UP) do nothing
        //if (keyCode == KeyCode.DOWN) do nothing
    }

    @Override
    public int getHeight() {
        return 80;
    }

    @Override
    public int getWidth() {
        return 32;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Paint.valueOf("#FF0000"));
        graphicsContext.fillRect(getX(), getY() + 16, 32, 32);
        graphicsContext.fillRect(getX() + 8, getY() - 16, 16, 48);
    }
}
