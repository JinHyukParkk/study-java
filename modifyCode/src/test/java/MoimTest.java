
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MoimTest {

    @Test
    public void isFull() {
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfEnrollment = 10;

        assertThat(moim.isEnrollmentFull()).isFalse();
    }
}
