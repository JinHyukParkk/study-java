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

    @Test
    void yieldTest() {
        String day = "MONDAY";
        int a = switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> {
                yield 6;
            }
            case "TUESDAY" -> {
                yield 7;
            }
            case "THURSDAY", "SATURDAY" -> {
                yield 8;
            }
            case "WEDNESDAY" -> {
                yield 9;
            }
            default -> {
                yield 0; // 다른 경우에 대한 기본 값
            }
        };

        System.out.println(a);
    }
}
