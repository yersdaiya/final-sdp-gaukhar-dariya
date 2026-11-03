package com.school.model;

public class Admin extends Person {
    public Admin(String id, String name) {
        super(id, name, "ADMIN", "MANAGE_USERS", "MANAGE_SCHEDULE", "VIEW_ALL_REPORTS");
    }
}
