package base;

import java.util.function.*;

public class BaseFIExample {
    public static void main(String[] args) {
        //Predicate<T> -> boolean test(T t);
        //Predicate используется для проверки условия
        //например проверка числа на положительность
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(5));

        //Function<T,R> -> R apply(T t);
        //Function используется для преобразования одного типа в другой
        //например преобразование числа в строку
        Function<Integer, String> convertToString = String::valueOf;
        System.out.println(convertToString.apply(5));

        //Consumer<T> -> void accept(T t);
        //Consumer используется для выполнения действий над объектом
        //например вывод текста на экран
        Consumer<String> printString = x -> System.out.println("Вывод текста: " + x);
        printString.accept("Hello");

        //Supplier<T> -> T get();
        //Supplier используется для получения объекта
        //например случайного числа
        Supplier<Integer> randomNumber = () -> (int) (Math.random() * 100);
        System.out.println(randomNumber.get());

        //UnaryOperator<T> -> T apply(T t);
        //UnaryOperator используется для преобразования объекта в объект того же типа
        //например возведение числа в квадрат
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5));
    }
}
