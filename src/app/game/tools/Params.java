package app.game.tools;

import java.util.Random;

/**
 * Params
 *
 * @author Bernardo Copstein
 * @author Rafael Copstein
 */

public class Params {
    public static final String WINDOW_TITLE = "SpaceFX";
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    private static Params params = null;
    private Random rnd;

    private Params() {
        rnd = new Random();
    }

    public static Params getInstance() {
        if (params == null) {
            params = new Params();
        }
        return (params);
    }

    public int nextInt(int lim) {
        return (rnd.nextInt(lim));
    }
}
