package xyz.javablog.logic;

import xyz.javablog.common.CellTypes;
import xyz.javablog.common.matrixes.Matrix;

/**
 * Created by alexander on 12/08/2017.
 */

public class MatrixHandler {

    private MatrixHandler() {
    }

    public static boolean isNull(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] != CellTypes.EMPTY) return false;
            }
        }
        return true;
    }
}
