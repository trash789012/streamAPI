package base.consumer.logExamples;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

public class MultiLogger {
    public static void main(String[] args) {
        //Логгер в консоль
        Consumer<String> consoleLogger = message -> System.out.println("[CONSOLE] " + message);

        //Логгер в файл (с обработкой IOException)
        Consumer<String> fileLogger = message -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
                writer.write("[FILE] " + message);
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            }
        };

        //Комбинированный логгер (выводит в консоль и в файл)
        Consumer<String> combinedLogger = consoleLogger.andThen(fileLogger);

        //Пример использования
        combinedLogger.accept("Система инициализирована");
        combinedLogger.accept("Пользователь admin выполнил вход");
    }
}
