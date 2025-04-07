package lambda.methodReference;

import simple.firstExample.MathOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.IntFunction;

public class MethReferenceExample {

    public static void main(String[] args) {
        //1 - Статический метод
        //MathOperation sum = (x, y) -> x + y; //equivalent
        MathOperation sum = Integer::sum;
        System.out.println(sum.calculate(3, 8));

        //2 - Метод экземпляра
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "one", "two", "three");

        //list.forEach( s -> System.out.println(s) );

        //можно записать ссылку на метод
        //Чтобы объяснить компилятору, что функцию нужно именно передать,
        //а не вызвать, перед именем метода ставим не точку, а два двоеточия
//        list.forEach( (x) -> System.out.println(x)); //аналогично
        list.forEach(System.out::println);

        //3 - Метод произвольного объекта
        Function<String, Integer> length = String::length;
        System.out.println(length.apply("12345"));

        //4 - Конструктор
        IntFunction<int[]> arrayCreator = int[]::new;
        int[] newArray = arrayCreator.apply(10);
        System.out.println("Длина массива: " + newArray.length);
    }

}
