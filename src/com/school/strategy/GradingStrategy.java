package com.school.strategy;

import com.school.model.Grade;
import java.util.List;


public interface GradingStrategy {
    double calculate(List<Grade> grades);
    String name();
}
