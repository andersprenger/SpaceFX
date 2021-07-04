package game.objects;

import game.Game;
import game.tools.Params;
import javafx.scene.canvas.GraphicsContext;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents the basic game character
 *
 * @author Anderson Sprenger
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */
public abstract class Entity implements GameObject {
    int direction_horizontal = 0, direction_vertical = 0;
    int lminV = 0, lmaxV = Params.WINDOW_HEIGHT;
    int lminH = 0, lmaxH = Params.WINDOW_WIDTH;
    int width = 32, height = 32;
    boolean collided = false;
    boolean active = true;
    int posX, posY;
    int speed = 2;

    List<Integer> collidersId;

    public static int idGenerator = 0;

    int id;

    public Entity(int startX, int startY) {
        posX = startX;
        posY = startY;

        collidersId = new LinkedList<>();

        id = idGenerator;
        idGenerator++;
    }

    @Override
    public int getId() {
        return id;
    }

    public void addCollider(GameObject o) {
        addCollider(o, true);
    }

    protected void addCollider(GameObject o, boolean b) {
        collidersId.add(o.getId());
        setCollide(b);
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
    public void testCollision(GameObject anotherGameObject) {
        if (collided || collidersId.contains(anotherGameObject.getId())) {
            return;
        }

        // Monta pontos
        int p1x = this.getX();
        int p1y = this.getY();
        int p2x = p1x + this.getWidth();
        int p2y = p1y + this.getHeight();

        int op1x = anotherGameObject.getX();
        int op1y = anotherGameObject.getY();
        int op2x = op1x + anotherGameObject.getWidth();
        int op2y = op1y + anotherGameObject.getHeight();

        // Verifica colisão
        if (p1x < op2x && p2x > op1x && p1y < op2y && p2y > op1y) {
            this.addCollider(anotherGameObject);
            anotherGameObject.addCollider(this);
        }
    }

    // por default, uma entidade não eh inimiga...
    @Override
    public boolean isEnemy() {
        return false;
    }

    public int getDirH() {
        return direction_horizontal;
    }

    public int getDirV() {
        return direction_vertical;
    }

    public int getLMinH() {
        return lminH;
    }

    public int getLMaxH() {
        return lmaxH;
    }

    public int getLMinV() {
        return lminV;
    }

    public int getLMaxV() {
        return lmaxV;
    }

    public int getSpeed() {
        return speed;
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
        return collided;
    }

    @Override
    public void setCollide(boolean b) {
        collided = true;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public abstract void start();

    @Override
    public abstract void update(long deltaTime);

    @Override
    public abstract void draw(GraphicsContext graphicsContext);
}
