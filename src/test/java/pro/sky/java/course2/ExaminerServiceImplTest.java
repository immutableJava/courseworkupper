package pro.sky.java.course2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;
import pro.sky.java.course2.examinerservice.service.ExaminerService;
import pro.sky.java.course2.examinerservice.service.ExaminerServiceImpl;
import pro.sky.java.course2.examinerservice.service.QuestionRepository;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    private ExaminerServiceImpl examinerServiceImpl;

    @BeforeEach
    public void init() {
        examinerServiceImpl = new ExaminerServiceImpl(questionService, questionService);
    }

    @Test
    public void shouldGenerateMathQuestionList() {
        Question q = new Question("5 + 5", "10");
        when(questionService.getRandomQuestion()).thenReturn(q);
        assertEquals(q, examinerServiceImpl.getQuestions(1));
    }

    @Test
    public void shouldReturnCorrectLength() {
        Question q = new Question("6 + 7", "13");
        when(questionService.getRandomQuestion()).thenReturn(q);
        questionService.add(q);
        assertEquals(examinerServiceImpl.getQuestions(1).size(), 1);
    }
}
