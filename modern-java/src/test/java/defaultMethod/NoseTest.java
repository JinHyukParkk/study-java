package defaultMethod;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class NoseTest {

    @Test
    void defalutMethod() {
        assertThat(new Nose().isEmpty()).isTrue();
        assertThat(new Nose(10).isEmpty()).isFalse();
    }

    @Test
    void test() {
        List<String> list = Arrays.asList("a", "b", "c");

        list.set(2, "d");
//        list.add("d");

        list.forEach(System.out::println);
    }
}
