package homework.Task6;

public class Task6 {

    static TriFunction<Double, Double, Double, double[]> solveQuadratic = (a, b, c) -> {
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            throw  new ArithmeticException("Нет действительных корней");
        }

        double sqrtDiscriminant = Math.sqrt(discriminant);
        return new double[] {
                ( -b + sqrtDiscriminant) / (2 * a),
                ( -b - sqrtDiscriminant) / (2 * a),
        };
    };

    public static void main(String[] args) throws Exception {
        var roots = solveQuadratic.apply(1.0, -5.0, 6.0);
        System.out.println("Корни уравнения: " + roots[0] + ", " + roots[1]);
    }
}
