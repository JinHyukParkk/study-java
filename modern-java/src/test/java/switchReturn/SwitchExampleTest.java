package switchReturn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwitchExampleTest {

    @Test
    void test() {
        assertEquals("Monday", getDayOfWeek(1));
        assertEquals("Tuesday", getDayOfWeek(2));
        assertThrows(IllegalArgumentException.class, () -> getDayOfWeek(3));

        assertEquals("Monday", getDayOfWeek2(1));
        assertEquals("Tuesday", getDayOfWeek2(2));
        assertThrows(IllegalArgumentException.class, () -> getDayOfWeek2(3));
    }

    private String getDayOfWeek(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            default -> throw new IllegalArgumentException("Invalid day of the week: " + day);
        };
    }

    private String getDayOfWeek2(int day) {
        return switch (day) {
            case 1 -> {
                yield "Monday";
            }
            case 2 -> {
                yield "Tuesday";
            }
            default -> {
                throw new IllegalArgumentException("Invalid day of the week: " + day);
            }
        };
    }
}
