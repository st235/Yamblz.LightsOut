package xyz.javablog.session;

import java.util.Stack;

import xyz.javablog.Engine;
import xyz.javablog.common.Field;
import xyz.javablog.common.matrixes.Matrix;
import xyz.javablog.common.matrixes.MutableMatrix;
import xyz.javablog.common.points.Point;
import xyz.javablog.common.sizes.Size;
import xyz.javablog.logic.MatrixEngine;


/**
 * Created by Grechka on 12.08.2017.
 */

public class Session implements Engine {
    MatrixEngine matrixEngine;
    Field field = null;
    Field originField;
    MutableMatrix originMatrix;
    MutableMatrix activeMatrix;
    Stack<Point> history = new Stack<>();

    public Session(MatrixEngine matrixEngine) {
        this.matrixEngine = matrixEngine;
    }

    @Override
    public Field obtainNewField(Size size) {
        history.clear();
        originMatrix = matrixEngine.generate(size);
        activeMatrix = originMatrix;
        return null;
    }

    @Override
    public Field clickCurrentField (Point point) throws SessionNotObtainedException {
        if (field == null) {
            throw new SessionNotObtainedException("");
        }

        history.push(point);

        return null;
    }

    @Override
    public Field getOriginField() throws SessionNotObtainedException {
        if (field == null) {
            throw new SessionNotObtainedException("");
        }

        activeMatrix = originMatrix;
        history.clear();
        return null;
    }

    @Override
    public Field getPreviousField(int steps) throws SessionNotObtainedException {
        if (field == null) {
            throw new SessionNotObtainedException("");
        }

        for (int i = 0; i < steps; i++) {
            field = matrixEngine.pushForward(history.pop(), activeMatrix);
        }
        return field;
    }

    @Override
    public int calculateCurrentScore() throws SessionNotObtainedException {
        if (field == null) {
            throw new SessionNotObtainedException("");
        }
        return 0;
    }
}
