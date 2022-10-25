package defaultMethod.diamond;

public interface B extends A {

    default void hello() {
        System.out.println("I am B");
    }
}
