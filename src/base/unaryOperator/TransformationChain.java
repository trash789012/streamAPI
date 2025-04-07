package base.unaryOperator;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class TransformationChain {
    public static void main(String[] args) {
        //Цепочка преобразований данных
        UnaryOperator<Integer> square = x -> x * x;
        UnaryOperator<Integer> doubleValue = x -> x * 2;
        UnaryOperator<Integer> addOne = x -> x + 1;

        //Комбинирование операторов в цепочку
        Function<Integer, Integer> pipeline = square.andThen(doubleValue).andThen(addOne);

        //Применение цепочки преобразований к числу
        int result = pipeline.apply(3);
        System.out.println("Результат: " + result);
    }
}
