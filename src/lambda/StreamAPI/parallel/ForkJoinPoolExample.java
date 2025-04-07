package lambda.StreamAPI.parallel;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolExample {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        //Создаем свой ForkJoinPool с 4 потоками
        try (ForkJoinPool customPoll = new ForkJoinPool(4)) {
            int sum = customPoll.submit(() ->
                            numbers.parallelStream()
                                    .mapToInt(n -> n)
                                    .sum())
                    .get();

            System.out.println("Сумма: " + sum);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
