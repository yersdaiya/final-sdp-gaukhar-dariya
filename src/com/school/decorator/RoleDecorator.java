package com.school.decorator;

import com.school.model.Account;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class RoleDecorator implements Account {
    protected final Account wrapped;

    protected RoleDecorator(Account wrapped) { this.wrapped = wrapped; }

    protected abstract String roleName();
    protected abstract List<String> extraPermissions();

    @Override public String getId() { return wrapped.getId(); }
    @Override public String getName() { return wrapped.getName(); }
    @Override public String getRole() { return wrapped.getRole() + "+" + roleName(); }

    @Override public Set<String> getPermissions() {
        Set<String> all = new LinkedHashSet<>(wrapped.getPermissions());
        all.addAll(extraPermissions());
        return all;
    }

    @Override public String describe() { return getRole() + " " + getName() + " " + getPermissions(); }
}
