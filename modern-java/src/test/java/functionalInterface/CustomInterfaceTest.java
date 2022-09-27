package functionalInterface;

import org.junit.jupiter.api.Test;

class CustomInterfaceTest {

    @Test
    void callTest() {
        CustomInterface<Object> custom = () -> "call me";

        System.out.println(custom.call());
    }
}