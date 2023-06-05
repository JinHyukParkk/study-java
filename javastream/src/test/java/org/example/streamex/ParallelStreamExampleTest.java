package org.example.streamex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ParallelStreamExampleTest {

    List<Integer> numbers = new ArrayList<>();
    long startTime;

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 10000; i++) {
            numbers.add(i);
        }
        startTime = System.currentTimeMillis();
    }

    @Test
    @DisplayName("Stream")
    void case1() {
        numbers.stream()
            .forEach(number -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        System.out.println("Stream: " + (System.currentTimeMillis() - startTime));
    }

    @Test
    @DisplayName("ParallelStream")
    void case2() {
        numbers.parallelStream()
            .forEach(number -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        System.out.println("ParallelStream: " + (System.currentTimeMillis() - startTime));
    }
}
