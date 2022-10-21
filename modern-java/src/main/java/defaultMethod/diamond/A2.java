package defaultMethod.diamond;

public interface A2 {

    default void hello() {
        System.out.println("I am A");
    }
}
