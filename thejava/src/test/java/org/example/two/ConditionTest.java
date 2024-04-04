package org.example.two;

import org.example.anotations.FastTest;
import org.example.anotations.SlowTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class ConditionTest {

    @Test
    @EnabledOnOs(OS.MAC)
    void test_os_mac() {
        System.out.println("mac");
    }

    @Test
    @DisabledOnOs(OS.MAC)
    void test_os_mac2() {
        System.out.println("mac2");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9, JRE.JAVA_11})
    void test_java_version() {
        System.out.println("java");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void test_env() {
        System.out.println("local");
    }

    @FastTest
    void test_fast() {
        System.out.println("fast");
    }

    @SlowTest
    void test_slow() {
        System.out.println("slow");
    }
}
