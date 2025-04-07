package lambda.syntaxCommon;

import java.util.Comparator;

public class LambdaVariantsCall {
    public static void main(String[] args) {
        //без параметров
        Runnable task = () -> System.out.println("Hello!");

        //с параметрами
        Comparator<String> comparator = (s1, s2) -> s1.length() - s2.length();

        //сравнение с анонимным классом
        //анонимный класс
        Runnable oldWay = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        };

        //лямбда
        Runnable newWay = () -> System.out.println("Hello!");
    }
}
