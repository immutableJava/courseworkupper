package pro.sky.java.course2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.service.JavaQuestionService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaQuestionServiceTest {
    JavaQuestionService out = new JavaQuestionService();

    private static Stream<Arguments> remove() {
        return Stream.of(Arguments.of((new Question("Сколько будет 5 + 5", "5 + 5 = 10")),
                (new Question("Сколько будет 3 + 1", "3 + 1 = 4")),
                (new Question("Сколько будет 2 + 7", "2 + 7 = 9")),
                (new Question("Сколько будет 6 + 1", "6 + 1 = 7"))));
    }

    @Test
    public void shouldReturnSomeQuestion() {
        out.add(new Question("Сколько будет 5 + 5", "5 + 5 = 10"));
        out.add(new Question("Сколько будет 3 + 1", "3 + 1 = 4"));
        out.add(new Question("Сколько будет 2 + 7", "2 + 7 = 9"));
        out.add(new Question("Сколько будет 6 + 1", "6 + 1 = 7"));
        assertTrue(out.getAll().contains(out.getRandomQuestion()));
    }

    @ParameterizedTest
    @MethodSource("remove")
    public void shouldReturnRemovedQuestion(Question question) {
        out.add(new Question("Сколько будет 5 + 5", "5 + 5 = 10"));
        out.add(new Question("Сколько будет 3 + 1", "3 + 1 = 4"));
        out.add(new Question("Сколько будет 2 + 7", "2 + 7 = 9"));
        out.add(new Question("Сколько будет 6 + 1", "6 + 1 = 7"));
        out.remove(question);
        assertFalse(out.getAll().contains(question));
    }
}
