package closure;

import java.util.function.Supplier;

public class ClosureExample {
    public static void main(String[] args) {
        int x = 10; //effectively final (не изменяется после инициализации)

        //Лямбда захватывает переменную x из внешнего лексического окружения
        Supplier<Integer> getX = () -> x;

        //Лямбда запоминает значение X, даже если метод main уже завершится
        System.out.println(getX.get());
    }
}
