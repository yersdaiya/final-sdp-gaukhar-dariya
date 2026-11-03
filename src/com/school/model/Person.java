package com.school.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Person implements Account {
    private final String id;
    private final String name;
    private final String role;
    private final Set<String> permissions = new LinkedHashSet<>();

    protected Person(String id, String name, String role, String... perms) {
        this.id = id;
        this.name = name;
        this.role = role;
        Collections.addAll(permissions, perms);
    }

    @Override public String getId() { return id; }
    @Override public String getName() { return name; }
    @Override public String getRole() { return role; }
    @Override public Set<String> getPermissions() { return Collections.unmodifiableSet(permissions); }
    @Override public String describe() { return role + " " + name + " " + getPermissions(); }
}
