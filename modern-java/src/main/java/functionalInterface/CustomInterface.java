package functionalInterface;

@FunctionalInterface
public interface CustomInterface<T> {
    // FunctionalInterface는 abstract method는 하나여야함
    T call();

    default void printDefault() {
        System.out.println("default method");
    }

    static void printStatic() {
        System.out.println("static method");
    }
}
