package time;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

class TimeExampleTest {

    @Test
    void periodTest() {
        Period period = Period.between(LocalDate.of(2021, 3, 1), LocalDate.of(2023, 10, 18));
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        System.out.println(period.getYears());
    }

    @Test
    void DurationTest() {
        Duration duration = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println(duration.getSeconds());
    }
}
