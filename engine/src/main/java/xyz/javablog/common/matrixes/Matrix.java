package xyz.javablog.common.matrixes;

import xyz.javablog.common.cells.Cell;
import xyz.javablog.common.points.Point;

/**
 * Created by alexander on 12/08/2017.
 */

public interface Matrix {
    Cell getCell(Point point);
    int[][] toRawArray();
}
