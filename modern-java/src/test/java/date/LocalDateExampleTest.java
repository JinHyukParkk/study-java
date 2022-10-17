package date;

import java.time.LocalDate;
import java.time.Month;
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
}
