package game;

import game.framework.BasicElement;
import game.framework.Game;
import game.framework.Params;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 * Represents a simple ball that crosses the screen over and over again
 *
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public class Ball extends BasicElement {
    public Ball(int px, int py) {
        super(px, py);
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
                setSpeed(Params.getInstance().nextInt(5) + 1);
            }
        }
    }

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Paint.valueOf("#FFFF00"));
        graphicsContext.fillOval(getX(), getY(), 32, 32);
    }
}
