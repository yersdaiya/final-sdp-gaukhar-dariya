package com.school.observer;

import com.school.model.Grade;
import com.school.singleton.SchoolDatabase;

import java.util.ArrayList;
import java.util.List;

public class GradeBook {
    private final List<GradeObserver> observers = new ArrayList<>();

    public void attach(GradeObserver o) { observers.add(o); }
    public void detach(GradeObserver o) { observers.remove(o); }

    public void addGrade(String studentId, Grade grade) {
        SchoolDatabase.getInstance().saveGrade(studentId, grade);
        GradeEvent event = new GradeEvent(studentId, grade);
        for (GradeObserver o : new ArrayList<>(observers)) o.update(event);
    }
}
