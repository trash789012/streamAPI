package homework.Task7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class PredicateCompositionTask {

    public record Person(String name, int age, String city) {}

    public static List<Person> filterByConditions(List<Person> people, Map<String, Predicate<Person>> conditions){

        //Проверка на неизвестные поля
        Set<String> validFields = Set.of("name", "age", "city");
        conditions.keySet().forEach(field -> {
            if (!validFields.contains(field)){
                throw new IllegalArgumentException("Invalid field: " + field);
            }
        });

        //Создаем единый предикат для всех условий
        Predicate<Person> combinedPredicate = conditions.values()
                .stream()
                .reduce(Predicate::and)
                .orElse(person -> true); //Если нет условий, возвращаем все

        return people.stream()
                .filter(combinedPredicate)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", 25, "New York"),
                new Person("Alice", 30, "San Francisco"),
                new Person("Bob", 20, "Chicago")
        );

        //Условия, возраст больше 22 и город - New York
        Map<String, Predicate<Person>> conditions = new HashMap<>();
        conditions.put("age", person -> person.age() > 22);
        conditions.put("city", person -> person.city().equals("New York"));

        //Фильтруем
        List<Person> filteredPeople = filterByConditions(people, conditions);
        filteredPeople.forEach(System.out::println);
    }
}
