package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.exceptions.NoQuestionException;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @PostConstruct
    public void init() {
        javaQuestionRepository.add(getRandomQuestion());
    }

    public Question add(String question, String answer) {
        Question currentQuestion = new Question(question, answer);
        return add(currentQuestion);
    }

    @Override
    public Question add(Question question) {
        javaQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        javaQuestionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> questions = javaQuestionRepository.getAll();
        int randomDigit = new Random().nextInt(questions.size());
        Iterator<Question> i = questions.iterator();
        int counter = 0;
        while (i.hasNext()) {
            if (counter == randomDigit) {
                return i.next();
            }
            i.next();
            counter++;
        }
        throw new NoQuestionException();
    }
}
