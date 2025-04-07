package homework.Task3;

import java.util.function.Function;

public class Task3 {

    record Person(String name, int age) {}

    public static void main(String[] args) {
        Function<Person, String> personInfo = person -> {
            if (person.age() <= 0) {
                throw new IllegalArgumentException("Возраст должен быть положительным");
            }
            return String.format("Имя: %s, Возраст: %d", person.name(), person.age());
        };

        System.out.println(personInfo.apply(new Person("Иван", 25)));
    }
}
