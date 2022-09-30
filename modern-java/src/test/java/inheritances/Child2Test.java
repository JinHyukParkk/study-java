package inheritances;

import inheritances.parent.Child1;
import inheritances.parent.Child2;
import inheritances.parent.Parent;
import org.junit.jupiter.api.Test;

class Child2Test {

    @Test
    void printTest() {
        Parent child1 = new Child1();
        child1.printTest();

        Parent child2 = new Child2();
        child2.printTest();
    }
}
