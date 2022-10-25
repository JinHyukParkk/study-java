package functionalInterface;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
