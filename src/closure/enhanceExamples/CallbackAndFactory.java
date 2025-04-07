package closure.enhanceExamples;

import java.util.function.Consumer;
import java.util.function.Function;

public class CallbackAndFactory {
    public static void main(String[] args) {
        // Фабрика функций для обработки чисел
        Function<Integer, Integer> processor = createProcessor("square");
        int result = processData(5, processor, r -> System.out.println("Результат: " + r));

        // Результат: 25
    }

    // Фабрика функций
    public static Function<Integer, Integer> createProcessor(String type) {
        return switch (type) {
            case "square" -> x -> x * x;
            case "double" -> x -> x * 2;
            default -> x -> x;
        };
    }

    // Метод с коллбэком
    public static int processData(int input, Function<Integer, Integer> processor, Consumer<Integer> callback) {
        int result = processor.apply(input);
        callback.accept(result);
        return result;
    }
}
