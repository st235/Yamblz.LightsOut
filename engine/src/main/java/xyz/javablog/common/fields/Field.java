package xyz.javablog.common.fields;

import xyz.javablog.common.matrixes.Matrix;
import xyz.javablog.common.sizes.Size;

/**
 * Created by alexander on 12/08/2017.
 */

public interface Field {
    Size getSize();
    Matrix getMatrix();

    boolean isSolved();
}
