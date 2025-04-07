package base.binaryOperator;

import java.util.List;
import java.util.function.BinaryOperator;

public class ProductAnalyzer {
    public static void main(String[] args) {
        record Product(String name, double price) {}

        List<Product> products = List.of(
                new Product("Телефон", 1000),
                new Product("Ноутбук", 2000),
                new Product("Планшет", 500)
        );

        //Создаем BinaryOperator для нахождения максимальной цены
        BinaryOperator<Product> maxPrice = (product1, product2) -> {
            if (product1.price > product2.price) {
                return product1;
            } else {
                return product2;
            }
        };

        Product mostExpensiveProduct = products.stream().reduce(maxPrice).orElse(null);

        System.out.println("Самый дорогой продукт: " + mostExpensiveProduct.name +
                           ", цена: " + mostExpensiveProduct.price);
    }
}
