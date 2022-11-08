package optional.example1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class OptionalUtilityTest {

    @Test
    void test() {
        Map<String, Integer> map = new HashMap<>();
        map.put("test", 1);

        System.out.println(Optional.ofNullable(map.getOrDefault("A", null)).orElse(1));
    }

}