package xyz.javablog.logic;

import com.sun.istack.internal.NotNull;

import xyz.javablog.common.matrixes.Matrix;
import xyz.javablog.common.matrixes.MutableMatrix;
import xyz.javablog.common.points.Point;
import xyz.javablog.common.sizes.Size;

public interface MatrixEngine {
    MutableMatrix generate(@NotNull Size size);
    MutableMatrix pushForward(@NotNull Point point, @NotNull MutableMatrix matrix);
}
