package xyz.javablog.logic;

import xyz.javablog.common.matrixes.MutableMatrix;
import xyz.javablog.common.points.Point;
import xyz.javablog.common.sizes.Size;

public class GameMatrixEngine implements MatrixEngine {

    @Override
    public MutableMatrix generate(Size size) {
        MutableMatrix matrix = new GameMutableMatrix(size);
        Point[] points = PointHandler.obtainRandomPoints(size);
        for (Point point: points) matrix.performClick(point);
        return matrix;
    }

    @Override
    public MutableMatrix pushForward(Point point, MutableMatrix matrix) {
        matrix.performClick(point);
        return matrix;
    }
}
