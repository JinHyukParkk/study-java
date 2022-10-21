package defaultMethod;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NoseTest {

    @Test
    void defalutMethod() {
        assertThat(new Nose().isEmpty()).isTrue();
        assertThat(new Nose(10).isEmpty()).isFalse();
    }
}
