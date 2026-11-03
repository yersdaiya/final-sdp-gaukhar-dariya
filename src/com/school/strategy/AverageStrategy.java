package com.school.strategy;

import com.school.model.Grade;
import java.util.List;

public class AverageStrategy implements GradingStrategy {
    @Override public double calculate(List<Grade> grades) {
        return grades.stream().mapToDouble(Grade::score).average().orElse(0);
    }
    @Override public String name() { return "Arithmetic average (0-100)"; }
}
