package lambda.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;

public class FileReaderExample {
    public static void main(String[] args) {
        //В таком виде обычная лямбда не компилируется из за IO Exception
        //Function<String, List<String>> readFile = path -> Files.readAllLines(Paths.get(path));

        //Можно обернуть в try/catch, но не очень красиво
//        Function<String, List<String>> readFiles = path -> {
//            try {
//                return Files.readAllLines(Paths.get(path));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        };

        //Теперь посмотрим на более изящный способ, используем unchecked обертку
        Function<String, List<String>> readFile = ThrowingFunction.function(
                path -> Files.readAllLines(Paths.get(path))
        );

        //Главное, что мы имеем обертку над функцией, которая может выбросить IOException
        //теперь мы можем применить эту функцию и обработать возможное исключение в блоке try
        try {
            List<String> lines = readFile.apply("missed.txt");
            lines.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
