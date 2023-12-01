package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringRemoveExampleTest {

    @Test
    void testStringRepeat() {
        // 문자열 반복 기능 테스트
        String original = "Hello, Java 8!";
        String repeated = original.repeat(3);

        assertEquals("Hello, Java 8!Hello, Java 8!Hello, Java 8!", repeated);
    }

    @Test
    void testStringStrip() {
        // 문자열 공백 제거 기능 테스트
        String original = "  Hello, Java 8!  ";
        String stripped = original.strip();

        assertEquals("Hello, Java 8!", stripped);
    }

    @Test
    void testStringStripLeading() {
        // 문자열 왼쪽 공백 제거 기능 테스트
        String original = "  Hello, Java 8!  ";
        String stripped = original.stripLeading();

        assertEquals("Hello, Java 8!  ", stripped);
    }

    @Test
    void testStringStripTrailing() {
        // 문자열 오른쪽 공백 제거 기능 테스트
        String original = "  Hello, Java 8!  ";
        String stripped = original.stripTrailing();

        assertEquals("  Hello, Java 8!", stripped);
    }

    @Test
    void testStringIsBlank() {
        String str1 = "";
        String str2 = " ";

        System.out.println(str1.isBlank());
        System.out.println(str2.isBlank());
    }

    @Test
    void testStringIsEmpty() {
        String str1 = "";
        String str2 = " ";

        System.out.println(str1.isEmpty());
        System.out.println(str2.isEmpty());
    }
}
