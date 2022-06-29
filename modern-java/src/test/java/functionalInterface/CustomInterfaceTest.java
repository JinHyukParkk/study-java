package functionalInterface;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomInterfaceTest {

    @Test
    void callTest() {
        CustomInterface<Object> custom = () -> "call me";

        System.out.println(custom.call());
    }
}