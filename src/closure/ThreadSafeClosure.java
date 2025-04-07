package closure;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeClosure {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        String message = "Замыкание в потоке";

        // Лямбда захватывает message (effectively final)
        executor.submit(() -> System.out.println(message));

        executor.shutdown();
    }
}
