package base.binaryOperator;

import java.util.function.BinaryOperator;

public class MatrixMultiplier {
    public static void main(String[] args) {
        //BinaryOperator для умножения двух матриц 2х2
        BinaryOperator<int[][]> multiply = (matrix1, matrix2) -> {
            int[][] result = new int[2][2];

            result[0][0] = matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0];
            result[0][1] = matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1];
            result[1][0] = matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[1][0];
            result[1][1] = matrix1[1][0] * matrix2[0][1] + matrix1[1][1] * matrix2[1][1];

            return result;
        };

        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6}, {7, 8}};
        int[][] result = multiply.apply(matrix1, matrix2);

        //Вывод результата
        System.out.println("Результат умножения матриц:");
        System.out.println(result[0][0] + " " + result[0][1]);
        System.out.println(result[1][0] + " " + result[1][1]);
    }
}
