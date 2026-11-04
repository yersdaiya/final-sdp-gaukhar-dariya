package com.school.facade;

import com.school.builder.ReportCard;
import com.school.builder.ReportCardBuilder;
import com.school.decorator.*;
import com.school.factory.AccountFactory;
import com.school.factory.UserType;
import com.school.model.Account;
import com.school.model.Grade;
import com.school.observer.*;
import com.school.singleton.SchoolDatabase;
import com.school.strategy.GradingStrategy;
import com.school.strategy.WeightedStrategy;

public class SchoolFacade {
    private final SchoolDatabase db = SchoolDatabase.getInstance();
    private final GradeBook gradeBook = new GradeBook();
    private GradingStrategy strategy = new WeightedStrategy();

    public SchoolFacade() {
        gradeBook.attach(new EmailNotifier());
    }

    public void setGradingStrategy(GradingStrategy s) { this.strategy = s; }

    public String enrollStudent(String studentName, String parentName) {
        Account student = AccountFactory.of(UserType.STUDENT).create(db.nextId("STU"), studentName);
        Account parent = AccountFactory.of(UserType.PARENT).create(db.nextId("PAR"), parentName);
        db.saveAccount(student);
        db.saveAccount(parent);
        db.linkParent(student.getId(), parent.getId());

        gradeBook.attach(new StudentNotifier(student.getId(), studentName));
        gradeBook.attach(new ParentNotifier(student.getId(), studentName, parentName));
        return student.getId();
    }

    public String hireTeacher(String name) {
        Account t = AccountFactory.of(UserType.TEACHER).create(db.nextId("TCH"), name);
        db.saveAccount(t);
        return t.getId();
    }

    /** roleName: CLASS_TEACHER | DEPARTMENT_HEAD | EXAM_SUPERVISOR */
    public Account assignRole(String accountId, String roleName) {
        Account base = db.getAccount(accountId);
        Account decorated = switch (roleName) {
            case "CLASS_TEACHER"    -> new ClassTeacherRole(base);
            case "DEPARTMENT_HEAD"  -> new DepartmentHeadRole(base);
            case "EXAM_SUPERVISOR"  -> new ExamSupervisorRole(base);
            default -> throw new IllegalArgumentException("Unknown role: " + roleName);
        };
        db.saveAccount(decorated);
        return decorated;
    }


    public void assignGrade(String teacherId, String studentId, String subject, double score, double weight) {
        Account teacher = db.getAccount(teacherId);

        if (!teacher.getPermissions().contains("ASSIGN_GRADES")) {
            throw new SecurityException(teacher.getName() + " cannot assign grades");
        }

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }

        gradeBook.addGrade(studentId, new Grade(subject, score, weight));
    }


    public ReportCard generateReport(String studentId, String term, String comment) {
        return new ReportCardBuilder()
                .student(db.getAccount(studentId).getName())
                .term(term)
                .comment(comment)
                .strategy(strategy)
                .grades(db.getGrades(studentId))
                .build();
    }

    public Account getAccount(String id) { return db.getAccount(id); }
}
