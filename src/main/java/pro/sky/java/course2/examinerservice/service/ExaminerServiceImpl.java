package pro.sky.java.course2.examinerservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionServiceMath;
    private final QuestionService questionServiceJava;

    public ExaminerServiceImpl(@Qualifier("mathQuestionService") QuestionService questionServiceMath,@Qualifier("javaQuestionService") QuestionService questionServiceJava) {
        this.questionServiceMath = questionServiceMath;
        this.questionServiceJava = questionServiceJava;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionSet = new HashSet<>();
       int javaQuestionsAmount = (int) (Math.random() * 11);
      while (questionSet.size() < javaQuestionsAmount) {
            Question question = questionServiceJava.getRandomQuestion();
            if(questionSet.contains(question)){
                continue;
            }
            questionSet.add(question);
        }
        while (questionSet.size() < amount) {
            Question question = questionServiceMath.getRandomQuestion();
            if(questionSet.contains(question)){
                continue;
            }
            questionSet.add(question);
        }
        return questionSet;
    }
}
