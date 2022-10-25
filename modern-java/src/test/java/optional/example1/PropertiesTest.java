package optional.example1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertiesTest {

    Properties properties = new Properties();

    @BeforeEach
    void setUp() {
        properties.setProperties("a", "1");
        properties.setProperties("b", "true");
        properties.setProperties("c", "-1");
        properties.setProperties("d", "99");

        properties.setProperties("a", "2");
    }

    @Test
    void printAll() {
        properties.getList().forEach((key, value) -> System.out.println(
                String.format("key : %s, value : %s", key, value)));
    }

    @Test
    void getPropertiesTest() {
        assertThat(properties.getProperties("a")).isEqualTo(2);
        assertThat(properties.getProperties("b")).isEqualTo(0);
        assertThat(properties.getProperties("c")).isEqualTo(0);
        assertThat(properties.getProperties("d")).isEqualTo(99);
    }
}
