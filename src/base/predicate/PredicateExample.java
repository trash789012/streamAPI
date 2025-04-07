package base.predicate;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        //Проверка на четность
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4));
        System.out.println(isEven.test(5));

        //Фильтрация списка чисел на четные
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream().filter(isEven).toList();
        evenNumbers.forEach(System.out::println);

        //Дополнительные методы для Predicate
        //четные и больше пяти
        List<Integer> numbersGTFive = numbers.stream().filter(isEven.and(x -> x > 5)).toList();

        //negate() - инвертирует условие
        //все нечетные
        List<Integer> isNotEven = numbers.stream().filter(isEven.negate()).toList();
    }
}
