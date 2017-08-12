package xyz.javablog.logic;

import xyz.javablog.models.Field;
import xyz.javablog.models.Matrix;
import xyz.javablog.models.Point;

public interface MatrixEngine {
    Field pushForward(Point point, Matrix matrix);
    Field pushBackward(Point point, Matrix matrix);
}
