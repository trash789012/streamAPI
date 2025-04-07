package lambda.StreamAPI.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionsProblemExample {
    private static int counter = 0;
    private static int counterSync = 0;
    private static final AtomicInteger counterAtom = new AtomicInteger(0);

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10000; i++){
            numbers.add(i);
        }

        //Параллельное увеличение счетчика приводит к Race Condition
        numbers.parallelStream().forEach(n -> {
            counter++;
        });

        System.out.println("Ожидаемое значение счетчика 10000");
        System.out.println("Фактическое значение счетчика: " + counter);

        //для решения можно использовать атомарные классы, например AtomicInteger
        numbers.parallelStream().forEach(n -> {
            counterAtom.incrementAndGet();
        });

        System.out.println("Атомарный счетчик:" + counterAtom);

        //Использовать синхронищацию, но это замедляет работу потоков
        numbers.parallelStream().forEach(n -> {
            synchronized (RaceConditionsProblemExample.class) {
                counterSync++;
            }
        });

        System.out.println("Синхронизация, но очень медленно: " + counterSync);

        //Использовать reduce или count
        var count = numbers.parallelStream().count();
        System.out.println("count: " + count);

        //Вариант с методом reduce
        var reduceCount = numbers.parallelStream()
                .reduce(0 , (subtotal, element) -> subtotal + 1, Integer::sum);
        System.out.println("reduceCount: " + reduceCount);
    }
}
