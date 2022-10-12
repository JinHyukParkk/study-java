package optional;

import java.util.Optional;

public class Person {

    private Car car;

    private Optional<Car> getCarAsOptional() {
        return Optional.ofNullable(car);
    }
}
