package xyz.javablog.logic;

import logic.models.MutableMatrix;
import logic.utils.PointUtils;
import models.Cell;
import models.Point;
import models.Size;

public class GameMutableMatrix implements MutableMatrix {

    private int width;
    private int height;

    private int[][] matrix;

    public GameMutableMatrix(Size size) {
        this.width = size.getWidth();
        this.height = size.getHeight();
        this.matrix = new int[width][height];
    }

    @Override
    public void performClick(Point point) {
        int[][] possibleClickArea = PointUtils.getNeighbours(point.getX(), point.getY());

        for(int i = 0; i < PointUtils.AREAS_COUNT; i++) {
           int[] possibleClick = possibleClickArea[i];
           int x = possibleClick[0];
           int y = possibleClick[1];

           if (!PointUtils.isValidPoint(width, height, x, y)) continue;
           matrix[x][y] = PointUtils.switchArea(matrix[x][y]);
        }
    }

    @Override
    public Cell getCell(Point point) {
        return null;
    }

    @Override
    public int[][] toRawArray() {
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                builder.append(matrix[i][j]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
