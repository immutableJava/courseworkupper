package pro.sky.java.course2;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;
import pro.sky.java.course2.examinerservice.repository.MathQuestionRepository;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {

    @Mock
    private MathQuestionRepository out;

    private static Stream<Arguments> remove() {
        return Stream.of(Arguments.of((new Question("Сколько будет 5 + 5", "5 + 5 = 10")),
                (new Question("Сколько будет 3 + 1", "3 + 1 = 4")),
                (new Question("Сколько будет 2 + 7", "2 + 7 = 9")),
                (new Question("Сколько будет 6 + 1", "6 + 1 = 7"))));
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
