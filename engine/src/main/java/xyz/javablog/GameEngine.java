package xyz.javablog;

import xyz.javablog.calculator.GameScoreCalculator;
import xyz.javablog.calculator.ScoreCalculator;
import xyz.javablog.calculator.ScoreTypes;
import xyz.javablog.common.fields.Field;
import xyz.javablog.common.points.Point;
import xyz.javablog.common.sizes.Size;
import xyz.javablog.logic.GameMatrixEngine;
import xyz.javablog.logic.MatrixEngine;
import xyz.javablog.session.GameSession;
import xyz.javablog.session.Session;

import static xyz.javablog.session.SessionProvider.checkSession;

/**
 * Created by alexander on 12/08/2017.
 */

public class GameEngine implements Engine {

    private Session session;
    private MatrixEngine matrixEngine;

    public GameEngine() {
        this.matrixEngine = new GameMatrixEngine();
    }

    @Override
    public Field obtainNewField(Size size) {
        this.session = new GameSession(matrixEngine);
        return session.init(size);
    }

    @Override
    public Field clickCurrentField(Point point) {
        checkSession(session);
        return session.clickForward(point);
    }

    @Override
    public Field getOriginField() {
        checkSession(session);
        return session.getOrigin();
    }

    @Override
    public Field getPreviousField(int steps) {
        checkSession(session);
        return session.clickBackward(steps);
    }

    @Override
    public int calculateCurrentScore(long timeInMillis, int clicks) {
        checkSession(session);
        ScoreCalculator calculator = new GameScoreCalculator();
        return calculator.push(ScoreTypes.TIME, timeInMillis)
                .push(ScoreTypes.CLICKS, clicks)
                .calculate();
    }
}
