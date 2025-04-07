package lambda.exceptions;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction<T, R, E extends Exception> {
    R apply(T t) throws E;

    public static <T, R> Function<T, R> function(ThrowingFunction<T, R, ?> throwingFunction) {
        return t -> {
            try {
                return throwingFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
