package xyz.javablog.common.points;

/**
 * Created by alexander on 12/08/2017.
 */

public class GamePoint implements Point {

    private int x;
    private int y;

    public GamePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
