package xyz.javablog.calculator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grechka on 12.08.2017.
 */

public class GameScoreCalculator implements ScoreCalculator {
    private Map<Integer, Double> weightMap = new HashMap<>();
    private double result = 0;

    public GameScoreCalculator() {
        weightMap.put(ScoreTypes.CLICKS, 0.81);
        weightMap.put(ScoreTypes.TIME, 0.00007);
    }

    @Override
    public ScoreCalculator push(int type, long value) {
        Double weight = weightMap.get(type);
        result += 10000 / (weight * value);
        return this;
    }

    @Override
    public int calculate() {
        return ((int) Math.round(result));
    }
}
