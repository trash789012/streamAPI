package base.unaryOperator;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public class DataNormalizer {
    public static void main(String[] args) {
        double[] data = {10.0, 20.0, 30.0, 40.0, 50.0};
        double max = Arrays.stream(data).max().orElse(1.0);

        //UnaryOperator для нормализации данных
        UnaryOperator<Double> normalize = x -> x / max;

        System.out.println("Нормализованные данные:");
        Arrays.stream(data)
                .map(normalize::apply)
                .forEach(System.out::println);
    }
}
