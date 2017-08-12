package xyz.javablog;

import xyz.javablog.common.Field;
import xyz.javablog.common.points.Point;
import xyz.javablog.common.sizes.Size;

public interface Engine {
    Field obtainNewField(Size size);
    Field clickCurrentField(Point point);
    Field getOriginField();
    Field getPreviousField(int steps);

    int calculateCurrentScore();
}
