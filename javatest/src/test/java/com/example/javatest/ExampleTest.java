package com.example.javatest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(FindSlowTestExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@TestInstance(Lifecycle.PER_CLASS)  // 클래스 영역에서 인스턴스 하나 생성
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // 순서를 정하는 어노테이션 (@Order)와 같이 쓴다
class ExampleTest {

    int count = 1;

    @Order(2)
    @Test
    @DisplayName("예시 만들기")
    void create_new_example() {
        Example example = new Example(ExampleType.START, 1);

        assertNotNull(example);

        System.out.println(count++);
    }

    @Order(1)
    @Test
    @Tag("again")
    void create_new_example_again() {
        Example example = new Example(ExampleType.START, 1);

        assertAll(
                () -> assertNotNull(example),
                () -> assertTrue(true)
        );

        System.out.println(count++);
    }

    @Order(3)
    @Test
    @Tag("again")
    void create_new_example_again2() {
        Example example = new Example(ExampleType.START, 2);

        assertAll(
                () -> assertNotNull(example),
                () -> assertTrue(true)
        );

        System.out.println(count++);
    }

    @Order(4)
    @Test
    void limitOverExample_thenExceptionShouldBeThrown() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> new Example(ExampleType.END, -10));

        assertEquals("limit은 0보다 커야한다.", exception.getMessage());
    }
}
