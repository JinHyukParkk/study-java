package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class EmptyListExampleTest {

    @Test
    void emptyListTest_case1() {
        List<Integer> empty = Collections.emptyList();

        try {
            empty.add(1);
        } catch (Exception e) {
            System.out.printf("class : %s, message : %s%n", e.getClass(), e.getMessage());
        }
    }

    @Test
    void emptyListTest_case2() {
        List<Integer> empty = Collections.EMPTY_LIST;

        try {
            empty.add(1);
        } catch (Exception e) {
            System.out.printf("class : %s, message : %s%n", e.getClass(), e.getMessage());
        }

        // uses unchecked or unsafe operations.
        //Note: Recompile with -Xlint:unchecked for details. g형변환 ?
    }
}
