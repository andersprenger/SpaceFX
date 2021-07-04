package game;

import javafx.scene.canvas.GraphicsContext;

/**
 * Represents the basic game character
 *
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public abstract class Entity implements Character {
    int direction_horizontal = 0, direction_vertical = 0;
    int lminV = 0, lmaxV = Params.WINDOW_HEIGHT;
    int lminH = 0, lmaxH = Params.WINDOW_WIDTH;
    int width = 32, height = 32;
    boolean collided = false;
    boolean active = true;
    int posX, posY;
    int speed = 2;

    public Entity(int startX, int startY) {
        posX = startX;
        posY = startY;
    }

    @Override
    public int getX() {
        return (posX);
    }

    @Override
    public int getY() {
        return (posY);
    }

    @Override
    public int getHeight() {
        return (height);
    }

    @Override
    public int getWidth() {
        return (width);
    }

    @Override
    public void testCollision(Character anotherCharacter) {
        if (collided) {
            return;
        }

        // Monta pontos
        int p1x = this.getX();
        int p1y = this.getY();
        int p2x = p1x + this.getWidth();
        int p2y = p1y + this.getHeight();

        int op1x = anotherCharacter.getX();
        int op1y = anotherCharacter.getY();
        int op2x = op1x + anotherCharacter.getWidth();
        int op2y = op1y + anotherCharacter.getHeight();

        // Verifica colisão
        if (p1x < op2x && p2x > op1x && p1y < op2y && p2y > op1y) {
            collided = true;
        }
    }

    public int getDirH() {
        return (direction_horizontal);
    }

    public int getDirV() {
        return (direction_vertical);
    }

    public int getLMinH() {
        return (lminH);
    }

    public int getLMaxH() {
        return (lmaxH);
    }

    public int getLMinV() {
        return (lminV);
    }

    public int getLMaxV() {
        return (lmaxV);
    }

    public int getSpeed() {
        return (speed);
    }

    public void setPosX(int p) {
        posX = p;
    }

    public void setPosY(int p) {
        posY = p;
    }

    public void setLargAlt(int l, int a) {
        width = l;
        height = a;
    }

    public void setDirH(int dirH) {
        direction_horizontal = dirH;
    }

    public void setDirV(int dirV) {
        direction_vertical = dirV;
    }

    public void setLimH(int min, int max) {
        lminH = min;
        lmaxH = max;
    }

    public void setLimV(int min, int max) {
        lminV = min;
        lmaxV = max;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public void deactivate() {
        active = false;
        Game.getInstance().eliminate(this);
    }

    @Override
    public boolean didCollide() {
        return (collided);
    }

    @Override
    public void setCollide() {
        collided = true;
    }

    @Override
    public boolean isActive() {
        return (active);
    }

    @Override
    public abstract void start();

    @Override
    public abstract void update(long deltaTime);

    @Override
    public abstract void draw(GraphicsContext graphicsContext);
}
