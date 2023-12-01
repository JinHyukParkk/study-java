package string;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StringExampleTest {
    @Test
    void testStringJoin() {
        // 문자열 조인 기능 테스트
        String[] words = {"Hello", "World", "Java", "8"};
        String result = String.join(" ", words);

        assertEquals("Hello World Java 8", result);
    }

    @Test
    void testStringStream() {
        // 문자열 스트림 및 람다를 사용한 문자열 조작 테스트
        String text = "Java 8 is awesome!";

        // 문자열을 공백으로 분리하고, 각 단어를 대문자로 변환한 후 다시 조인합니다.
        String processedText = text
            .chars()
            .mapToObj(c -> (char) c)
            .filter(Character::isLetterOrDigit)
            .map(Character::toUpperCase)
            .map(String::valueOf)
            .collect(Collectors.joining());

        assertEquals("JAVA8ISAWESOME", processedText);
    }

    @Test
    void testStringReplace() {
        // 문자열 대체 기능 테스트
        String original = "Hello, Java 8!";
        String replaced = original.replace("8", "World");

        assertEquals("Hello, Java World!", replaced);
    }

    @Test
    void testStringRepeat() {
        // 문자열 반복 기능 테스트
        String original = "Hello, Java 8!";
        String repeated = original.repeat(3);

        assertEquals("Hello, Java 8!Hello, Java 8!Hello, Java 8!", repeated);
    }
}
