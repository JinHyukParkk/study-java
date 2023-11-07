package grammer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FinalTest {

    @Test
    void finalTest() {
        final String hello = "hello world!";

//        hello = "world2";    // error
    }

    @Test
    void finalListTest() {
        final List<String> finalList = new ArrayList<>();
        finalList.add("Hello");
        finalList.add("World");


        // The following is allowed - we are not changing the reference, we are modifying the object it points to
        System.out.println(finalList);
    }
}
