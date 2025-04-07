package simple.firstExample;

public class MathOperationExample {
    public static void main(String[] args) {
        //умножение
        MathOperation multiply = new MathOperation() {
            @Override
            public int calculate(int x, int y) {
                return x * y;
            }
        };

        System.out.println(multiply.calculate(3, 8));
    }
}
