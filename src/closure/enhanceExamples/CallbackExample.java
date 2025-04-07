package closure.enhanceExamples;

import java.util.function.Consumer;

public class CallbackExample {
    public static void main(String[] args) {
        //Коллбэки для обработки успеха и ошибки
        Consumer<String> onSuccess = result -> System.out.println("Данные получены: " + result);
        Consumer<String> onError = error -> System.out.println("Ошибка: " + error);

        //Симуляция запроса
        loadData(onSuccess, onError);
    }

    //Симуляция запроса, принимает коллбэки для обработки успеха и ошибки
    private static void loadData(Consumer<String> onSuccess, Consumer<String> onError) {
        boolean isSuccess = Math.random() > 0.5; //симуляция успеха или ошибки

        if (isSuccess) {
            onSuccess.accept("{name: Nikita, age: 30}");
        } else {
            onError.accept("Сервер недоступен");
        }
    }
}
