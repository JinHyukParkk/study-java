package defaultMethod.diamond;

public interface A {

    default void hello() {
        System.out.println("I am A");
    }
}
