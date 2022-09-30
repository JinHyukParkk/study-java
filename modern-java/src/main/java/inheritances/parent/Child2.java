package inheritances.parent;

public class Child2 extends Parent {

    private static final String TEST = "test-child";

    @Override
    protected String getTest() {
        return TEST;
    }
}
