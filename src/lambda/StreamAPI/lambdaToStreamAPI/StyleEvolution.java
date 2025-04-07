package lambda.StreamAPI.lambdaToStreamAPI;

import java.util.ArrayList;
import java.util.List;

public class StyleEvolution {
    public static void main(String[] args) {
        //Императивный стиль
        List<String> list = List.of("Annet", "Villa", "Alex", "Nikolay");
        List<String> filtered = new ArrayList<>();
        for (String s: list){
            if (s.startsWith("A")){
                filtered.add(s.toUpperCase());
            }
        }

        //Декларативный стиль (Stream API + лямбды)
        List<String> filteredNames = list.stream()
                .filter(s -> s.startsWith("A"))
                .map(String::toUpperCase)
                .toList();
    }
}
