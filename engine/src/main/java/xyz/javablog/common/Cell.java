package xyz.javablog.common;

import xyz.javablog.common.points.Point;

/**
 * Created by alexander on 12/08/2017.
 */

public interface Cell {
    int getState();
    int getType();
    Point getCoordinates();
}
