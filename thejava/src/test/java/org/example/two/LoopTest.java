package org.example.two;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

class LoopTest {

    @DisplayName("Repeated Test")
    @RepeatedTest(value = 10, name = "{displayName} - {currentRepetition}/{totalRepetitions}")
    void test(RepetitionInfo repetitionInfo) {
        // test code
        System.out.println("Repetition " + repetitionInfo.getCurrentRepetition());
    }
}
