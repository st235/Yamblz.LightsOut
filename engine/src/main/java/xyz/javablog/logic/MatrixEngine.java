package xyz.javablog.logic;

import xyz.javablog.common.matrixes.MutableMatrix;
import xyz.javablog.common.points.Point;
import xyz.javablog.common.sizes.Size;

public interface MatrixEngine {
    MutableMatrix generate(Size size);
    MutableMatrix pushForward(Point point, MutableMatrix matrix);
}
