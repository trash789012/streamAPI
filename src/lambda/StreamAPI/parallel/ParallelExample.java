package lambda.StreamAPI.parallel;

import java.util.List;

public class ParallelExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Последовательная обработка
        long sequentialTime = measureTime( () -> {
            var result = numbers.stream()
                            .map(ParallelExample::compute)
                            .toList();
        });

        //Параллельная обработка
        long parallelTime = measureTime( () -> {
            var result = numbers.parallelStream()
                            .map(ParallelExample::compute)
                            .toList();
        });

        System.out.println("Sequential time: " + sequentialTime + "ms");
        System.out.println("Parallel time: " + parallelTime + "ms");
    }

    //Эмуляция долгой работы
    private static Integer compute(Integer n) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return n;
    }

    public static long measureTime(Runnable function) {
        long startTime = System.currentTimeMillis();
        function.run();
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}
