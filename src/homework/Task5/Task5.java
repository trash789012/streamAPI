package homework.Task5;

import java.util.function.UnaryOperator;

public class Task5 {
    public static void main(String[] args) {
        UnaryOperator<String> trim = String::trim;
        UnaryOperator<String> addPrefix = (s) -> "ID_" + s;
        UnaryOperator<String> replaceVowelsRus = (s) -> s.replaceAll(
                "[аеёиоуыэюяАЕЁИОУЫЭЮЯ]", "*");

        var result = trim.andThen(addPrefix).andThen(replaceVowelsRus).apply("Привет мир!");
        System.out.println(result);
    }
}
