package enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RainbowTest {

    @Test
    @DisplayName("values() 메소드 테스트")
    void valuesTest() {
        Rainbow[] arr = Rainbow.values();
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println();

        Rainbow2[] arr2 = Rainbow2.values();
        Arrays.stream(arr2).forEach(System.out::println);
    }

    @Test
    @DisplayName("valueOf() 메소드 테스트")
    void valueOfTest() {
        Rainbow rb = Rainbow.valueOf("BLUE");
        System.out.println(rb);

        Rainbow2 rb2 = Rainbow2.valueOf("BLUE");
        System.out.println(rb2);
    }

    @Test
    @DisplayName("ordinal() 메소드 테스트")
    void ordinalTest() {
        int idx = Rainbow.YELLOW.ordinal();
        System.out.println(idx);

        idx = Rainbow2.YELLOW.ordinal();
        System.out.println(idx);
    }
}
