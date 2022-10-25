package functionalInterface;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplierExample {

    public static String getExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Expensive";
    }

    public static void printWithValue(int number, String value) {
        if (number > 50) {
            System.out.println(String.format("%s Value", value));
        } else {
            System.out.println("Cheap Value");
        }
    }

    public static void printWithSupplier(int number, Supplier<String> supplier) {
        if (number > 50) {
            System.out.println(String.format("%s Value", supplier.get()));
        } else {
            System.out.println("Cheap Value");
        }
    }
}
