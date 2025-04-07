package base.consumer.logExamples;

import java.util.function.Consumer;

public class SimpleLogger {
    public static void main(String[] args) {
        //Создаем логгер, который выводит сообщения в консоль
        Consumer<String> consoleLogger = message -> System.out.println("[LOG] " + message);

        consoleLogger.accept("Приложение запущено");
        consoleLogger.accept("Произведено вычисление: " + (2 + 2));
    }
}
