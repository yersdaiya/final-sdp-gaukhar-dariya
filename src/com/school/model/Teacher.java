package com.school.model;

public class Teacher extends Person {
    public Teacher(String id, String name) {
        super(id, name, "TEACHER", "ASSIGN_GRADES", "VIEW_SCHEDULE");
    }
}
