package closure;
import java.util.function.Consumer;

public class MutableClosure {
    private int count = 0;

    public Consumer<String> getCounter() {
        // Лямбда захватывает поле count (может его изменять)
        return str -> {
            count++;
            System.out.println(str + ": " + count);
        };
    }

    public static void main(String[] args) {
        MutableClosure example = new MutableClosure();
        Consumer<String> counter = example.getCounter();

        counter.accept("Hello"); // Hello: 1
        counter.accept("World"); // World: 2
    }
}
