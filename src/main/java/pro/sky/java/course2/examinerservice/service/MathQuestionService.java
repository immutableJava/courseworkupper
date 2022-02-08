package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.exceptions.NoQuestionException;
import pro.sky.java.course2.examinerservice.repository.MathQuestionRepository;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class MathQuestionService implements QuestionService {
    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @PostConstruct
    public void init() {
        mathQuestionRepository.add(getRandomQuestion());
    }

    public Question add(String question, String answer) {
        Question currentQuestion = new Question(question, answer);
        return add(currentQuestion);
    }

    public Question add(Question question) {
        mathQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        mathQuestionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> questions = mathQuestionRepository.getAll();
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
