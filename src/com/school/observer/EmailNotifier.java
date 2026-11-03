package com.school.observer;

public class EmailNotifier implements GradeObserver {
    private static final double ALERT_THRESHOLD = 50;

    @Override public void update(GradeEvent e) {
        if (e.grade().score() < ALERT_THRESHOLD) {
            System.out.printf("  [Email to administration] ALERT: low score %.0f in %s (student %s)%n",
                    e.grade().score(), e.grade().subject(), e.studentId());
        }
    }
}
