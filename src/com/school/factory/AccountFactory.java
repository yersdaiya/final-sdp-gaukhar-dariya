package com.school.factory;

import com.school.model.*;

public abstract class AccountFactory {

    public abstract Account create(String id, String name);

    public static AccountFactory of(UserType type) {
        return switch (type) {
            case STUDENT -> new StudentFactory();
            case TEACHER -> new TeacherFactory();
            case ADMIN   -> new AdminFactory();
            case PARENT  -> new ParentFactory();
        };
    }

    static class StudentFactory extends AccountFactory {
        @Override public Account create(String id, String name) { return new Student(id, name); }
    }
    static class TeacherFactory extends AccountFactory {
        @Override public Account create(String id, String name) { return new Teacher(id, name); }
    }
    static class AdminFactory extends AccountFactory {
        @Override public Account create(String id, String name) { return new Admin(id, name); }
    }
    static class ParentFactory extends AccountFactory {
        @Override public Account create(String id, String name) { return new Parent(id, name); }
    }
}
