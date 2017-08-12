package xyz.javablog.session;

import java.util.Stack;

import xyz.javablog.common.fields.Field;
import xyz.javablog.common.fields.GameField;
import xyz.javablog.common.matrixes.MutableMatrix;
import xyz.javablog.common.points.Point;
import xyz.javablog.common.sizes.Size;
import xyz.javablog.logic.GameMutableMatrix;
import xyz.javablog.logic.MatrixEngine;


/**
 * Created by Grechka on 12.08.2017.
 */

public class GameSession implements Session {

    private boolean isSessionInit = false;
    private MatrixEngine matrixEngine;

    private Size size;
    private MutableMatrix originMatrix;
    private MutableMatrix activeMatrix;

    private Stack<Point> history = new Stack<>();

    public GameSession(MatrixEngine matrixEngine) {
        this.matrixEngine = matrixEngine;
    }

    @Override
    public Field init(Size size) {
        isSessionInit = true;
        this.size = size;
        this.originMatrix = matrixEngine.generate(size);
        this.activeMatrix = new GameMutableMatrix(size, originMatrix);
        return new GameField(size, activeMatrix);
    }

    @Override
    public Field getOrigin() {
        history.clear();
        activeMatrix = new GameMutableMatrix(size, originMatrix);
        return new GameField(size, activeMatrix);
    }

    @Override
    public Field clickForward(Point point) {
        history.push(point);
        this.activeMatrix = matrixEngine.pushForward(point, activeMatrix);
        return new GameField(size, activeMatrix);
    }

    @Override
    public Field clickBackward(int steps) {
        for (int i = 0; i < steps; i++) {
            Point last = history.pop();
            this.activeMatrix = matrixEngine.pushForward(last, activeMatrix);
        }
        return new GameField(size, activeMatrix);
    }

    @Override
    public boolean isInit() {
        return isSessionInit;
    }
}
