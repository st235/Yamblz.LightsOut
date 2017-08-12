package xyz.javablog.common.fields;

import xyz.javablog.common.matrixes.Matrix;
import xyz.javablog.common.sizes.Size;

/**
 * Created by alexander on 12/08/2017.
 */

public class GameField implements Field {

    private Size size;
    private Matrix matrix;
    private boolean solvedState = false;

    public GameField(Size size,
                     Matrix matrix) {
        this.size = size;
        this.matrix = matrix;
    }

    public GameField(Size size,
                     Matrix matrix,
                     boolean solvedState) {
        this.size = size;
        this.matrix = matrix;
        this.solvedState = solvedState;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public Matrix getMatrix() {
        return matrix;
    }

    @Override
    public boolean isSolved() {
        return solvedState;
    }
}
