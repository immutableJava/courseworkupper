package pro.sky.java.course2.examinerservice.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.service.JavaQuestionService;
import pro.sky.java.course2.examinerservice.service.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    Set<Question> questions = new HashSet<>();

    public Question add(String question, String answer) {
        Question currentQuestion = new Question(question, answer);
        return add(currentQuestion);
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
