package com.school.decorator;

import com.school.model.Account;
import java.util.List;

public class ExamSupervisorRole extends RoleDecorator {
    public ExamSupervisorRole(Account a) { super(a); }
    @Override protected String roleName() { return "EXAM_SUPERVISOR"; }
    @Override protected List<String> extraPermissions() {
        return List.of("PROCTOR_EXAM", "APPROVE_RETAKE");
    }
}
