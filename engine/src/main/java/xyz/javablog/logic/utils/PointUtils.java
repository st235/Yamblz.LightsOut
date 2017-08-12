package xyz.javablog.logic.utils;

public class PointUtils {

    public static final int AREAS_COUNT = 5;

    private PointUtils() {
    }

    public static int switchArea(int value) {
        return value == 0 ? 1 : 0;
    }

    public static int[][] getNeighbours(int x, int y) {
        return new int[][] {
                { x + 1, y }, { x - 1, y }, { x, y }, { x, y + 1 }, { x, y - 1 }
        };
    }

    public static boolean isValidPoint(int width, int height, int x, int y) {
        return x < height && x >= 0 && y < width && y >= 0;
    }
}
