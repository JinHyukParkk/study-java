package date;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;

class LocalDateExampleTest {

    @Test
    void test() {
        LocalDate date = LocalDate.of(2022, 10, 16);
        int year = date.getYear();
        System.out.println(year);
        Month month = date.getMonth();
        System.out.println(month);
    }

    @Test
    void testChronoField() {
        LocalDate nowDate = LocalDate.now();

        int year = nowDate.get(ChronoField.YEAR);
        int month = nowDate.get(ChronoField.MONTH_OF_YEAR);
        int day = nowDate.get(ChronoField.DAY_OF_MONTH);

        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
    }

    @Test
    void testWithAttribute() {
        LocalDate date = LocalDate.of(2022, 10, 18);
        System.out.println(date);

        LocalDate date1 = date.withYear(2021);
        System.out.println(date1);

        // withDayOfMonth 그 달의 N일
        LocalDate date2 = date1.withDayOfMonth(25);
        System.out.println(date2);

        // withDayOfYear 그 해의 N일
        LocalDate date3 = date2.withDayOfYear(233);
        System.out.println(date3);
    }

    @Test
    void testRelative() {
        LocalDate date = LocalDate.of(2022, 10, 18);
        System.out.println(date);

        LocalDate date1 = date.plusWeeks(1);
        System.out.println(date1);

        LocalDate date2 = date.minusYears(6);
        System.out.println(date2);

        LocalDate date3 = date.plus(6, ChronoUnit.MONTHS);
        System.out.println(date3);
    }
}
