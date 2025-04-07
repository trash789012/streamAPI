package lambda.StreamAPI.parallel;

import java.util.List;

public class EachOrderedProblemExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Последовательный поток (порядок сохранен)
        numbers.stream().forEach(n -> System.out.print(n + " "));

        System.out.println("\n");

        //Параллельный поток (порядок может быть нарушен)
        numbers.parallelStream().forEach(n -> System.out.print(n + " "));

        System.out.println("\n");

        //Решение - использовать forEachOrdered
        numbers.parallelStream().forEachOrdered(n -> System.out.print(n + " "));
    }
}