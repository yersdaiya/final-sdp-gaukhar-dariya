package com.school.singleton;

import com.school.model.Account;
import com.school.model.Grade;

import java.util.*;

public final class SchoolDatabase {
    private static SchoolDatabase instance;

    private final Map<String, Account> accounts = new LinkedHashMap<>();
    private final Map<String, List<Grade>> grades = new HashMap<>();
    private final Map<String, String> parentOf = new HashMap<>(); // studentId -> parentId
    private int counter = 0;

    private SchoolDatabase() {}

    public static synchronized SchoolDatabase getInstance() {
        if (instance == null) instance = new SchoolDatabase();
        return instance;
    }

    public String nextId(String prefix) { return prefix + "-" + (++counter); }

    public void saveAccount(Account a) { accounts.put(a.getId(), a); }
    public Account getAccount(String id) { return accounts.get(id); }

    public void linkParent(String studentId, String parentId) { parentOf.put(studentId, parentId); }
    public String getParentId(String studentId) { return parentOf.get(studentId); }

    public void saveGrade(String studentId, Grade g) {
        grades.computeIfAbsent(studentId, k -> new ArrayList<>()).add(g);
    }
    public List<Grade> getGrades(String studentId) {
        return grades.getOrDefault(studentId, List.of());
    }
}
