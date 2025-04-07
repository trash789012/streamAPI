package base.unaryOperator;

import java.util.List;
import java.util.function.UnaryOperator;

public class DiscountApplier {
    public static void main(String[] args) {
        //Unary Operator имеет один входной параметр и возвращает тот же тип данных
        //UnaryOperator<T> -> T apply(T t);
        //Пример: применение скидки 20 процентов к ценам товаров
        UnaryOperator<Double> applyDiscount = price -> price * 0.8;

        List<Double> prices = List.of(100.0, 200.0, 30.0);
        List<Double> discountedPrices = prices.stream()
                .map(applyDiscount)
                .toList();
        System.out.println("Цены со скидкой: " + discountedPrices);
    }
}
