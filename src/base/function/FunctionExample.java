package base.function;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionExample {
    public static void main(String[] args) {
        //Функциональный интерфейс для преобразования одного типа данных в другой
        //Function<T,R> -> R apply(T t);
        //Пример: преобразование списка строк в список чисел
        List<Integer> list = Stream.of("1","3","55", "66", "7777")
                .map(Integer::parseInt)
                .toList();

        list.forEach(System.out::println);

        //Цепочки преобразований
        Function<Integer, Integer> multiply = x -> x * 2;
        Function<Integer, Integer> add = x -> x + 5;
        Function<Integer, Integer> compositeFunction = multiply.andThen(add);

        System.out.println(compositeFunction.apply(10));

        //Цепочки преобразований через Stream
        List<Integer> numbers = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .map(x -> x * 2)
                .map(x -> x + 5)
                .toList();

        numbers.forEach(System.out::println);
    }
}
