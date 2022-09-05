package functionalInterface;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class ConsumerTest {

    // Consumer<T>는 T 타입의 객체를 인자로 받고 리턴 값은 없다.

    @Test
    void test() {
        Consumer<String> printString = text -> System.out.println("Miss " + text + "?");
        printString.accept("me");
    }

    @Test
    void andThen() {
        Consumer<String> printString = text -> System.out.println("Miss " + text + "?");
        Consumer<String> printString2 = text -> System.out.println("--> Yes");

        printString.andThen(printString2).accept("me");
    }
}

