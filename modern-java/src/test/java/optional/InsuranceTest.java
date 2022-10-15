package optional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class InsuranceTest {

    @Test
    void test() {
        Insurance insurance = new Insurance("hyuk");

        String name = null;
        if (insurance != null) {
            name = insurance.getName();
        }

        System.out.println(name);
    }

    @Test
    void optionalTest() {
        Insurance insurance = new Insurance("hyuk");

        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optionalInsurance.map(Insurance::getName);

        assertThat(name.orElse("")).isEqualTo("hyuk");

        System.out.println(name);
    }

    @Test
    void optionalNullTest() {
        Insurance insurance = null;

        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optionalInsurance.map(Insurance::getName);

        assertThat(name).isNotNull();

        System.out.println(name);
    }
}
