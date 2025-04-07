package closure;

import java.util.function.Supplier;

public class ErrorClosure {
    public static void main(String[] args) {
        int y = 20;
        y = 30; //нарушение effectively final, так как переменная изменяется после инициализации

        //Supplier<Integer> getY = () -> y; //Переменная в лямбда-выражении должна быть final или фактически final

        //Решение
        final int z = 20;
        Supplier<Integer> getZ = () -> z;
    }
}
