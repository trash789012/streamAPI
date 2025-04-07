package homework.Task8;

import java.util.List;

public class Student {
    String name;
    List<Integer> grades;

    Student(String name, List<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    double getAverageGrade() {
        return this.grades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }
}
