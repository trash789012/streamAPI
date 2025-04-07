package homework.Task8;

import java.util.Comparator;
import java.util.List;

public class Task8 {
    public static void main(String[] args) {
        //Студенты
        List<Student> students = List.of(
                new Student("John", List.of(85, 90, 95)),
                new Student("Jane", List.of(70, 80, 90)),
                new Student("Mary", List.of(65, 75, 85)),
                new Student("Mike", List.of(100, 97, 99)),
                new Student("Tom", List.of(60, 60, 55))
        );

        //Найдем топ три студента по среднему баллу
        List<Student> topStudents = students.stream()
                .sorted(Comparator.comparing(Student::getAverageGrade).reversed())
                .limit(3)
                .toList();

        System.out.println("Топ-3 студентов: ");
        topStudents.forEach(student -> {
            System.out.println(student.getName() + ": " + student.getAverageGrade());
        });
    }
}
