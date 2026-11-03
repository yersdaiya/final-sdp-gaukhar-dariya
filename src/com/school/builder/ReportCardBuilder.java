package com.school.builder;

import com.school.model.Grade;
import com.school.strategy.GradingStrategy;

import java.util.*;

public class ReportCardBuilder {
    private String studentName;
    private String term = "";
    private String comment = "";
    private GradingStrategy strategy;
    private final List<Grade> grades = new ArrayList<>();

    public ReportCardBuilder student(String name) { this.studentName = name; return this; }
    public ReportCardBuilder term(String term) { this.term = term; return this; }
    public ReportCardBuilder comment(String comment) { this.comment = comment; return this; }
    public ReportCardBuilder strategy(GradingStrategy s) { this.strategy = s; return this; }
    public ReportCardBuilder grades(List<Grade> g) { this.grades.addAll(g); return this; }

    public ReportCard build() {
        if (studentName == null || strategy == null)
            throw new IllegalStateException("Student and grading strategy are required");

        Map<String, List<Grade>> bySubject = new LinkedHashMap<>();
        for (Grade g : grades) bySubject.computeIfAbsent(g.subject(), k -> new ArrayList<>()).add(g);

        Map<String, Double> finals = new LinkedHashMap<>();
        bySubject.forEach((subj, list) -> finals.put(subj, strategy.calculate(list)));

        double overall = finals.values().stream().mapToDouble(Double::doubleValue).average().orElse(0);
        return new ReportCard(studentName, term, comment, strategy.name(), finals, overall);
    }
}
