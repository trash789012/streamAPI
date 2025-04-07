package homework.Task2;

import java.util.List;
import java.util.function.Predicate;

public class Task2 {
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isGTen = x -> x > 10;

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);

        System.out.println(filterList(list, isEven.and(isGTen)));
    }

    public static List<Integer> filterList(List<Integer> list, Predicate<Integer> predicate){
        return list.stream()
                .filter(predicate)
                .toList();
    }
}
