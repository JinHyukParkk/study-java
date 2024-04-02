package org.example.two;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {
//  junit5 에서는 public 접근제어자를 생략해도 된다. 이유는 5부터는 내부적으로 reflection을 사용하기 때문이다.
    @Test
    void test() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("test");
    }

    @Test
    @Disabled
    void test1() {
        System.out.println("test1");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }

}
