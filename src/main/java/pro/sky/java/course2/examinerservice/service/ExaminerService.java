package pro.sky.java.course2.examinerservice.service;

import pro.sky.java.course2.examinerservice.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
