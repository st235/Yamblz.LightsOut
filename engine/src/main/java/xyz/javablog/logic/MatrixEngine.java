package xyz.javablog.logic;

import xyz.javablog.models.Field;
import xyz.javablog.models.Point;

public interface MatrixEngine {
    Field pushForward(Point point);
    Field pushBackward(Point point);
}
