package com.school.model;

public class Student extends Person {
    public Student(String id, String name) {
        super(id, name, "STUDENT", "VIEW_OWN_GRADES", "VIEW_SCHEDULE");
    }
}
