package com.school;

import com.school.facade.SchoolFacade;
import com.school.strategy.FivePointStrategy;

public class Main {
    public static void main(String[] args) {
        SchoolFacade school = new SchoolFacade();

        System.out.println("--- 1. Factory + Facade: enrolling students and hiring a teacher ---");
        String aigerim = school.enrollStudent("Aigerim", "Mrs. Saule");
        String nursultan = school.enrollStudent("Nursultan", "Mr. Bolat");
        String teacher = school.hireTeacher("Ms. Dariya");
        System.out.println(school.getAccount(teacher).describe());

        System.out.println("\n--- 2. Decorator: adding roles dynamically ---");
        school.assignRole(teacher, "CLASS_TEACHER");
        school.assignRole(teacher, "EXAM_SUPERVISOR");
        System.out.println(school.getAccount(teacher).describe());

        System.out.println("\n--- 3. Observer: assigning grades triggers notifications ---");
        school.assignGrade(teacher, aigerim, "Math", 92, 3);
        school.assignGrade(teacher, aigerim, "Math", 85, 1);
        school.assignGrade(teacher, aigerim, "Physics", 78, 2);
        school.assignGrade(teacher, nursultan, "Math", 45, 3);   // triggers low-score alert

        System.out.println("\n--- 4. Strategy + Builder: report card (weighted, 0-100) ---");
        System.out.println(school.generateReport(aigerim, "Term 1", "Excellent progress"));

        System.out.println("\n--- 5. Strategy swapped at runtime: five-point scale ---");
        school.setGradingStrategy(new FivePointStrategy());
        System.out.println(school.generateReport(aigerim, "Term 1", "Excellent progress"));
        System.out.println(school.generateReport(nursultan, "Term 1", "Needs extra support"));
    }
}
