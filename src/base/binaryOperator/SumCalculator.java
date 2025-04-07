package base.binaryOperator;

import java.util.List;
import java.util.function.BinaryOperator;

public class SumCalculator {
    public static void main(String[] args) {
        BinaryOperator<Integer> sum = Integer::sum;

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int totalSum = numbers.stream().reduce(0, sum); //0 - начальное значение
        System.out.println("Сумма: " + totalSum);
    }
}
