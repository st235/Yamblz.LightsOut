package xyz.javablog.common.sizes;

public class SquareSize implements Size {

    private int width;
    private int height;

    public SquareSize(int n) {
        this.width = n;
        this.height = n;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
