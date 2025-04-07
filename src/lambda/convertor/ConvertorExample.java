package lambda.convertor;

public class ConvertorExample {

    public static void main(String[] args) {
        Convertor<Double, Double> celToKelvin = (c) -> c + 273.15;

        var result = celToKelvin.Convert(30.00);
        System.out.println(result);
    }
}
