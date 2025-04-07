package lambda.StreamAPI.parallel;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTest {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);

        //Последовательный поток быстрее
        var sequentialTime = measureTime(() -> {
            var result = numbers.stream().map(n -> n * n).toList();
        });

        var parallelTime = measureTime(() -> {
            var result = numbers.parallelStream().map(n -> n * n).toList();
        });

        System.out.println("Sequential time: " + sequentialTime + "ms");
        System.out.println("Parallel time: " + parallelTime + "ms");
    }

    public static long measureTime(Runnable function) {
        long startTime = System.nanoTime();
        function.run();
        long endTime = System.nanoTime();

        return endTime - startTime;
    }
}
