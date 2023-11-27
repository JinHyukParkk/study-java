package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemplateLiteralExampleTest {

    @Test
    void test() {
        String name = "hyuk";
        int age = 31;

        // """ 다음 칸에 써야함
        String message = """
            Hello, %s! I am %d years old.
            """.formatted(name, age);

        System.out.println(message);
    }

    @Test
    void test1() {
        String name = "hyuk";
        int age = 31;

        // """ 다음 칸에 써야함
        String message = """
            Hello, %s! I am %d years old.
            """.formatted(name, age)
                .replace("hyuk", "chul");

        System.out.println(message);
    }
}
