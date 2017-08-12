package xyz.javablog.calculator;

/**
 * Created by Grechka on 12.08.2017.
 */

public interface ScoreCalculator {

    ScoreCalculator push(int type, long value);

    int calculate();
}
