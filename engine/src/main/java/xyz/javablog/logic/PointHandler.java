package xyz.javablog.logic;

import java.util.Random;

import xyz.javablog.common.CellTypes;
import xyz.javablog.common.points.GamePoint;
import xyz.javablog.common.points.Point;
import xyz.javablog.common.sizes.Size;

public class PointHandler {

    public static final int AREAS_COUNT = 5;

    private static final Random random = new Random();

    private PointHandler() {
    }

    public static int switchArea(int value) {
        return value == CellTypes.EMPTY
                ? CellTypes.LIGHT : CellTypes.EMPTY;
    }

    public static int[][] getNeighbours(int x, int y) {
        return new int[][] {
                { x + 1, y }, { x - 1, y }, { x, y }, { x, y + 1 }, { x, y - 1 }
        };
    }

    public static boolean isValidPoint(int width, int height, int x, int y) {
        return x < height && x >= 0 && y < width && y >= 0;
    }

    public static Point[] obtainRandomPoints(Size size) {
        int limit = size.getWidth() * size.getHeight();

        int seed = random.nextInt(4) + 1;
        int randomLimit = random.nextInt(limit / seed);

        Point[] points = new Point[randomLimit];
        for (int i = 0; i < randomLimit; i++) {
            int x = random.nextInt(size.getHeight());
            int y = random.nextInt(size.getWidth());
            points[i] = new GamePoint(x, y);
        }

        return points;
    }
}
