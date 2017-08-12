package xyz.javablog.common.fields;

import xyz.javablog.common.GameState;
import xyz.javablog.common.matrixes.Matrix;
import xyz.javablog.common.sizes.Size;

/**
 * Created by alexander on 12/08/2017.
 */

public class GameField implements Field {

    private Size size;
    private Matrix matrix;

    public GameField(Size size,
                     Matrix matrix) {
        this.size = size;
        this.matrix = matrix;
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
    public GameState getGameState() {
        return null;
    }
}
