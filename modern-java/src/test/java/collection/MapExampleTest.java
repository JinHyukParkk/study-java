package collection;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapExampleTest {

    @Test
    void case1() {
        Map<String, String> map = Map.of("key1", "value1", "key2", "value2");

        assertEquals(2, map.size());
    }

    @Test
    void case2() {
        Map<String, String> map = Map.ofEntries(
                Map.entry("key1", "value1"),
                Map.entry("key2", "value2")
        );

        assertEquals(2, map.size());
    }
}
