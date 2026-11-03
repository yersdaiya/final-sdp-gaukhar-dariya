package com.school.observer;

import com.school.model.Grade;

public record GradeEvent(String studentId, Grade grade) {}
