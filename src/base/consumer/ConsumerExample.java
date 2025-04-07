package base.consumer;

import java.util.List;
import java.util.stream.Stream;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> names = Stream.of("John", "Jane", "Mary")
                .peek(x -> System.out.println("Hello " + x))
                .toList();
    }
}
