package com.school.decorator;

import com.school.model.Account;
import java.util.List;

public class DepartmentHeadRole extends RoleDecorator {
    public DepartmentHeadRole(Account a) { super(a); }
    @Override protected String roleName() { return "DEPARTMENT_HEAD"; }
    @Override protected List<String> extraPermissions() {
        return List.of("APPROVE_CURRICULUM", "VIEW_DEPARTMENT_REPORTS");
    }
}
