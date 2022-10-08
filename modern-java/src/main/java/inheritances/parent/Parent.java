package inheritances.parent;

public abstract class Parent {

    private static final String TEST = "test-parent";

    protected String getTest() {
        return TEST;
    }

    public void printTest() {
        System.out.println(getTest());
    }
}
