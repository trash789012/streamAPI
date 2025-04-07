package lambda.StreamAPI.exceptions;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamException {
    public static void main(String[] args) {
        Stream<String> stream =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"));
        Optional<String> anyElement = stream.findAny();
        Optional<String> firstElement = stream.findFirst(); //stream has already been operated upon or closed
        System.out.println(anyElement);
        System.out.println(firstElement);
    }
}
