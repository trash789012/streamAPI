package lambda.StreamAPI.simpleStreamAPI;

import java.util.List;

public class SimpleExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int sum = numbers.stream()                    //создание потока
                    .filter(x -> x % 2 == 0)          //промежуточная операция (фильтрация четных чисел)
                    .map(n -> n * n)                  //промежуточная операция (возведение в квадрат)
                    .reduce(0, Integer::sum); //терминальная операция (суммирование)
        System.out.println(sum);
    }
}
