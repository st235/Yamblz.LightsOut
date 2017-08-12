package xyz.javablog.common.points;

public class Click implements Point {

    private int touchX;
    private int touchY;

    public Click(int x, int y) {
        this.touchX = x;
        this.touchY = y;
    }

    @Override
    public int getX() {
        return touchX;
    }

    @Override
    public int getY() {
        return touchY;
    }
}
