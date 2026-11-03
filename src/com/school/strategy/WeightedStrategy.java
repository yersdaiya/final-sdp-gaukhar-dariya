package com.school.strategy;

import com.school.model.Grade;
import java.util.List;

public class WeightedStrategy implements GradingStrategy {
    @Override public double calculate(List<Grade> grades) {
        double totalWeight = grades.stream().mapToDouble(Grade::weight).sum();
        if (totalWeight == 0) return 0;
        double sum = grades.stream().mapToDouble(g -> g.score() * g.weight()).sum();
        return sum / totalWeight;
    }
    @Override public String name() { return "Weighted average (0-100)"; }
}
