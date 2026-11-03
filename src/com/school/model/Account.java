package com.school.model;

import java.util.Set;

public interface Account {
    String getId();
    String getName();
    String getRole();
    Set<String> getPermissions();
    String describe();
}
