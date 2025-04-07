package lambda.convertor;

@FunctionalInterface
public interface Convertor<T, N> {
    N Convert(T input);

    static <T> Boolean isNotNull(T input) {
        return input != null;
    }

    default void showInfo(T input) {
        System.out.println("Текущий объект - " + input.toString());
    }

    boolean equals(Object obj); //от Object
    //boolean EqualsObject(Object obj); //получим Compilation Error
}
