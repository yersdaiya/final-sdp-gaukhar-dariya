package com.school.builder;

import java.util.Map;

/** Готовый (неизменяемый) табель успеваемости. */
public class ReportCard {
    final String studentName, term, comment, strategyName;
    final Map<String, Double> subjectScores;
    final double overall;

    ReportCard(String studentName, String term, String comment, String strategyName,
               Map<String, Double> subjectScores, double overall) {
        this.studentName = studentName;
        this.term = term;
        this.comment = comment;
        this.strategyName = strategyName;
        this.subjectScores = subjectScores;
        this.overall = overall;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("==== REPORT CARD ====\n");
        sb.append("Student : ").append(studentName).append('\n');
        sb.append("Term    : ").append(term).append('\n');
        sb.append("Scale   : ").append(strategyName).append('\n');
        subjectScores.forEach((s, v) -> sb.append(String.format("  %-12s %.1f%n", s, v)));
        sb.append(String.format("Overall : %.1f%n", overall));
        if (!comment.isEmpty()) sb.append("Comment : ").append(comment).append('\n');
        sb.append("=====================");
        return sb.toString();
    }
}
