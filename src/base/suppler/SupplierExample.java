package base.suppler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SupplierExample {
    public static void main(String[] args) {
        //Получение случайного элемента из списка
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Mary");
        names.add("Mike");
        names.add("Tom");
        names.add("Alice");

        Stream.generate(() -> {
            int value = (int) (Math.random() * names.size());
            return names.get(value);
        }).limit(5).forEach(System.out::println);
    }
}
