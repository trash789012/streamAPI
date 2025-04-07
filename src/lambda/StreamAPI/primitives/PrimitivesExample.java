package lambda.StreamAPI.primitives;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitivesExample {
    public static void main(String[] args) {
        IntStream.range(1, 10)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

        DoubleStream.of(1.2, 3.4, 5.6)
                .map(n -> n * n)
                .forEach(System.out::println);
    }
}
