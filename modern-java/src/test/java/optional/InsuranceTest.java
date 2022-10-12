package optional;

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

        System.out.println(name);
    }

    @Test
    void optionalNullTest() {
        Insurance insurance = null;

        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optionalInsurance.map(Insurance::getName);

        System.out.println(name);
    }
}
