package xyz.javablog;

import xyz.javablog.models.Field;
import xyz.javablog.models.Point;
import xyz.javablog.models.Size;

public interface Engine {
    Field obtainNewField(Size size);
    Field clickCurrentField(Point point);
    Field getOriginField();
    Field getPreviousField(int steps);

    int calculateCurrentScore();
}
