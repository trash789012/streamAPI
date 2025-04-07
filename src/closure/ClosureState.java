package closure;

import java.util.function.Function;

public class ClosureState {
    public static void main(String[] args) {
        Function<Integer, Integer> adder = createAdder(5); //замыкание на 5
        System.out.println(adder.apply(3)); //5 + 3 = 8
    }

    public static Function<Integer, Integer> createAdder(int x) {
        return y -> x + y;
    }
}