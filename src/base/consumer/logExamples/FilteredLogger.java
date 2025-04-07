package base.consumer.logExamples;

import java.util.function.Consumer;

public class FilteredLogger {
    public static void main(String[] args) {
        //Базовый логгер, выводит все сообщения
        Consumer<String> baseLogger = message -> System.out.println("[ALL] " + message);

        //Фильтруемый логгер, выводит только сообщения, содержащие слово "error"
        Consumer<String> errorLogger = message -> {
            if (message.startsWith("ERROR")) {
                baseLogger.accept(message);
            }
        };

        //Пример испольования
        errorLogger.accept("INFO: user logged in"); //не будет выведено
        errorLogger.accept("ERROR: db connection failed"); //будет выведено
    }
}
