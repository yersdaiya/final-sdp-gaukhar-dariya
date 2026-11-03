package com.school.decorator;

import com.school.model.Account;
import java.util.List;

public class ClassTeacherRole extends RoleDecorator {
    public ClassTeacherRole(Account a) { super(a); }
    @Override protected String roleName() { return "CLASS_TEACHER"; }
    @Override protected List<String> extraPermissions() {
        return List.of("VIEW_CLASS_JOURNAL", "MESSAGE_PARENTS");
    }
}
