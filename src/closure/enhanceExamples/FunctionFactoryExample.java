package closure.enhanceExamples;

import java.util.function.UnaryOperator;

public class FunctionFactoryExample {
    public static void main(String[] args) {
        //Получаем функцию из фабрики
        UnaryOperator<String> toUpperCase = createFormatter("UPPER");
        UnaryOperator<String> toLowerCase = createFormatter("lower");

        //Применяем функцию к строкам
        System.out.println(toUpperCase.apply("Hello World")); //HELLO WORLD
        System.out.println(toLowerCase.apply("Hello World")); //hello world
    }

    public static UnaryOperator<String> createFormatter(String format) {
        return switch (format) {
            case "UPPER" -> String::toUpperCase;
            case "lower" -> String::toLowerCase;
            default -> s -> s;
        };
    }
}
