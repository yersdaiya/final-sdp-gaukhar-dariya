package com.school.observer;

public class StudentNotifier implements GradeObserver {
    private final String studentId, studentName;

    public StudentNotifier(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    @Override public void update(GradeEvent e) {
        if (!e.studentId().equals(studentId)) return;
        System.out.printf("  [Student app] %s: new grade in %s = %.0f%n",
                studentName, e.grade().subject(), e.grade().score());
    }
}
