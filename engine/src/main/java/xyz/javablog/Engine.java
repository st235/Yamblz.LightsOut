package xyz.javablog;

import xyz.javablog.common.fields.Field;
import xyz.javablog.common.points.Point;
import xyz.javablog.common.sizes.Size;

public interface Engine {
    Field obtainNewField(Size size);

    Field getOriginField();
    Field getPreviousField(int steps);

    Field clickCurrentField(Point point);
    int calculateCurrentScore();
}
