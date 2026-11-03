package com.school.observer;

public class ParentNotifier implements GradeObserver {
    private final String childId, parentName, childName;

    public ParentNotifier(String childId, String childName, String parentName) {
        this.childId = childId;
        this.childName = childName;
        this.parentName = parentName;
    }

    @Override public void update(GradeEvent e) {
        if (!e.studentId().equals(childId)) return;
        System.out.printf("  [Parent SMS] Dear %s, your child %s got %.0f in %s%n",
                parentName, childName, e.grade().score(), e.grade().subject());
    }
}
