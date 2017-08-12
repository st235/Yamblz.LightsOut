package xyz.javablog;

import xyz.javablog.common.Field;
import xyz.javablog.common.points.Point;
import xyz.javablog.common.sizes.Size;
import xyz.javablog.session.SessionNotObtainedException;

public interface Engine {
    Field obtainNewField(Size size);
    Field clickCurrentField(Point point) throws SessionNotObtainedException;
    Field getOriginField() throws SessionNotObtainedException;
    Field getPreviousField(int steps) throws SessionNotObtainedException;

    int calculateCurrentScore() throws SessionNotObtainedException;
}
