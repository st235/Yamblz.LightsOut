package xyz.javablog.models;

/**
 * Created by alexander on 12/08/2017.
 */

public interface Matrix {
    Cell getCell(Point point);

    int[][] toRawArray();
}
