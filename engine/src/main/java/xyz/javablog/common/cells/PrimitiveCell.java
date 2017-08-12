package xyz.javablog.common.cells;

import xyz.javablog.common.points.Point;

/**
 * Created by alexander on 12/08/2017.
 */

public class PrimitiveCell implements Cell {

    private int type;
    private Point point;

    public PrimitiveCell(int type,
                         Point point) {
        this.type = type;
        this.point = point;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public Point getCoordinates() {
        return point;
    }
}
