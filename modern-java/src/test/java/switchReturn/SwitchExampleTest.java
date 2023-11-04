package switchReturn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwitchExampleTest {

    @Test
    void test() {
        assertEquals("Monday", getDayOfWeek(1));
        assertEquals("Tuesday", getDayOfWeek(2));
        assertThrows(IllegalArgumentException.class, () -> getDayOfWeek(3));
    }

    private String getDayOfWeek(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            default -> throw new IllegalArgumentException("Invalid day of the week: " + day);
        };
    }
}
