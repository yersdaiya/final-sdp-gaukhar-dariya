package com.school.strategy;

import com.school.model.Grade;
import java.util.List;

public class FivePointStrategy implements GradingStrategy {
    private final WeightedStrategy weighted = new WeightedStrategy();

    @Override public double calculate(List<Grade> grades) {
        double s = weighted.calculate(grades);
        if (s >= 90) return 5;
        if (s >= 75) return 4;
        if (s >= 50) return 3;
        return 2;
    }
    @Override public String name() { return "Five-point scale (5/4/3/2)"; }
}
