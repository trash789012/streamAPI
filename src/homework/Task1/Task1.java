package homework.Task1;

import java.util.function.Consumer;

public class Task1 {
    public static void main(String[] args) {
        Consumer<String> printUpper = s -> {
            System.out.println(s != null ? s.toUpperCase() : "null");
        };

        printUpper.accept("hello");
        printUpper.accept(null);
    }
}
