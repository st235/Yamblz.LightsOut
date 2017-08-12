package xyz.javablog.logic;

import xyz.javablog.common.Field;
import xyz.javablog.common.matrixes.Matrix;
import xyz.javablog.common.points.Point;

public interface MatrixEngine {
    Field pushForward(Point point, Matrix matrix);
}
